package cu.todus.android.uiCompose.main.screen.chat.component;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.muxer.WebmConstants;
import androidx.p001lifecycle.ViewModelKt;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingDataTransforms__PagingDataTransformsKt;
import androidx.paging.PagingSource;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import cu.todus.android.R;
import cu.todus.android.connection.Quality;
import cu.todus.android.constants.Service;
import cu.todus.android.data.db.entity.cache.BotShortcut;
import cu.todus.android.data.db.entity.toDus.Contact;
import cu.todus.android.data.db.entity.toDus.MarkerAction;
import cu.todus.android.data.db.entity.toDus.Message;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.Sticker;
import cu.todus.android.data.db.entity.toDus.User;
import cu.todus.android.data.db.pojo.Friend;
import cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions;
import cu.todus.android.data.db.pojo.RoomMember;
import cu.todus.android.data.db.pojo.content.ContactContent;
import cu.todus.android.data.db.pojo.content.TemplateContent;
import cu.todus.android.data.db.pojo.messageentity.MentionName;
import cu.todus.android.data.preferences.AppState;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.data.wrapper.FlowsState;
import cu.todus.android.di.MainModule;
import cu.todus.android.di.MediaModule;
import cu.todus.android.di.PreferencesModule;
import cu.todus.android.domain.Domain;
import cu.todus.android.media.player.MediaPlayerData;
import cu.todus.android.notification.NotificationManager;
import cu.todus.android.repositories.BotShortcutRepository;
import cu.todus.android.repositories.MainRepository;
import cu.todus.android.repositories.RoomsRepository;
import cu.todus.android.repositories.StatusRepository;
import cu.todus.android.repositories.StickersRepository;
import cu.todus.android.repositories.UsersRepository;
import cu.todus.android.uiCompose.main.screen.chat.mentionList.MentionItemModel;
import cu.todus.android.uiCompose.navigation.NavLinks;
import cu.todus.android.uiCompose.shared.insideNotification.Cause;
import cu.todus.android.uiCompose.shared.insideNotification.InsideNotificationState;
import cu.todus.android.utils.CoroutineUtilsKt;
import cu.todus.android.utils.NumberInlineFunctionsKt;
import cu.todus.android.viewModel.ToDusViewModel;
import cu.todus.android.volatileState.AppVolatileState;
import cu.todus.android.xmpp.XMPPUtils;
import cu.todus.android.xmpp.extension.file.ExtensionFile;
import cu.z17.singledi.SinglediException;
import cu.z17.views.utils.Z17MutableListFlow;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import le.a0;
import le.d0;
import pe.d1;
import pe.m0;
import pe.w0;
import te.b0;
import te.p0;
import te.r0;
import ua.k0;
import ua.v;
import va.g0;
import va.w;
import va.x;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000Ô\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002Ð\u0001\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ4\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0082@¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ7\u0010\"\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u000b2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060 ¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00062\b\b\u0002\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0015\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0004¢\u0006\u0004\b)\u0010\u0019J[\u00101\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020$2\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040-2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b1\u00102J7\u00105\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00042\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00110-2\u0006\u00104\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b5\u00106J7\u00107\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00042\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00110-2\u0006\u00104\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b7\u00106J7\u00108\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00042\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00110-2\u0006\u00104\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b8\u00106J7\u00109\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00042\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00110-2\u0006\u00104\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b9\u00106J)\u0010<\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00042\u0006\u0010;\u001a\u00020:2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b<\u0010=J)\u0010@\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00042\u0006\u0010?\u001a\u00020>2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b@\u0010AJ\u0015\u0010C\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u0004¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\bE\u0010FJ\u0015\u0010G\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0004¢\u0006\u0004\bG\u0010\u0019J\u0015\u0010H\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u0004¢\u0006\u0004\bH\u0010\u0019J\u001d\u0010J\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004¢\u0006\u0004\bJ\u0010KJ\u0015\u0010L\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0004¢\u0006\u0004\bL\u0010\u0019J\u001d\u0010M\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004¢\u0006\u0004\bM\u0010KJ\u0015\u0010N\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0004¢\u0006\u0004\bN\u0010\u0019J\u0015\u0010O\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bO\u0010\u0019J!\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020R0Q0P2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bS\u0010TJ\u0015\u0010W\u001a\u00020\u00062\u0006\u0010V\u001a\u00020U¢\u0006\u0004\bW\u0010XJ\u0015\u0010Y\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0004¢\u0006\u0004\bY\u0010\u0019J\u001b\u0010[\u001a\u00020\u00062\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00040-¢\u0006\u0004\b[\u0010\\J\u001b\u0010]\u001a\u00020\u00062\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00040-¢\u0006\u0004\b]\u0010\\J#\u0010^\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00040-¢\u0006\u0004\b^\u0010_J\u001b\u0010a\u001a\u00020\u00062\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00040-¢\u0006\u0004\ba\u0010\\J\u0015\u0010c\u001a\u00020\u00062\u0006\u0010b\u001a\u00020R¢\u0006\u0004\bc\u0010dJ%\u0010h\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u00042\u0006\u0010f\u001a\u00020\u00042\u0006\u0010g\u001a\u00020\u0004¢\u0006\u0004\bh\u0010iJ\r\u0010j\u001a\u00020\u0006¢\u0006\u0004\bj\u0010\u0003J\u0015\u0010k\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bk\u0010\u0019J\u001d\u0010p\u001a\u00020\u00062\u0006\u0010m\u001a\u00020l2\u0006\u0010o\u001a\u00020n¢\u0006\u0004\bp\u0010qJ\r\u0010r\u001a\u00020\u0006¢\u0006\u0004\br\u0010\u0003J)\u0010t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010s\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00060\u001e¢\u0006\u0004\bt\u0010uJ!\u0010x\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020w0Q0P2\u0006\u0010v\u001a\u00020\u0004¢\u0006\u0004\bx\u0010TJ\u0013\u0010z\u001a\b\u0012\u0004\u0012\u00020y0-¢\u0006\u0004\bz\u0010{J)\u0010}\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010|\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00060\u001e¢\u0006\u0004\b}\u0010uJ\u0015\u0010~\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b~\u0010\u0019J'\u0010\u0081\u0001\u001a\u00020\u00062\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u00040-2\u0007\u0010\u0080\u0001\u001a\u00020\u0004¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J&\u0010\u0083\u0001\u001a\u00020\u00062\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00040-2\u0006\u0010o\u001a\u00020n¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J(\u0010\u0086\u0001\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0007\u0010\u0085\u0001\u001a\u00020\u0004¢\u0006\u0005\b\u0086\u0001\u0010iJ!\u0010\u0087\u0001\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u00042\u0007\u0010\u0085\u0001\u001a\u00020$¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J \u0010\u008a\u0001\u001a\u00020\u00062\u0007\u0010\u0089\u0001\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0005\b\u008a\u0001\u0010KJ\u0017\u0010\u008b\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0005\b\u008b\u0001\u0010\u0019J\u0017\u0010\u008c\u0001\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u0004¢\u0006\u0005\b\u008c\u0001\u0010\u0019J(\u0010\u008d\u0001\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u00042\u000e\b\u0002\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00060 ¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u0017\u0010\u008f\u0001\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u0004¢\u0006\u0005\b\u008f\u0001\u0010\u0019J\u0017\u0010\u0090\u0001\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u0004¢\u0006\u0005\b\u0090\u0001\u0010\u0019J:\u0010\u0094\u0001\u001a\u00020\u00062\u0007\u0010\u0091\u0001\u001a\u00020\u00042 \u0010\u0093\u0001\u001a\u001b\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00130\u0092\u0001\u0012\u0004\u0012\u00020\u00060\u001e¢\u0006\u0005\b\u0094\u0001\u0010uJ'\u0010\u0096\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\r\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060 ¢\u0006\u0006\b\u0096\u0001\u0010\u008e\u0001J'\u0010\u0097\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\r\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060 ¢\u0006\u0006\b\u0097\u0001\u0010\u008e\u0001J'\u0010\u0098\u0001\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\r\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060 ¢\u0006\u0006\b\u0098\u0001\u0010\u008e\u0001R\u0018\u0010\u009a\u0001\u001a\u00030\u0099\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0018\u0010\u009d\u0001\u001a\u00030\u009c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001d\u0010 \u0001\u001a\u00030\u009f\u00018\u0006¢\u0006\u0010\n\u0006\b \u0001\u0010¡\u0001\u001a\u0006\b¢\u0001\u0010£\u0001R\u0018\u0010¥\u0001\u001a\u00030¤\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u0018\u0010¨\u0001\u001a\u00030§\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u0018\u0010«\u0001\u001a\u00030ª\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u0018\u0010®\u0001\u001a\u00030\u00ad\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u0018\u0010±\u0001\u001a\u00030°\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u0018\u0010´\u0001\u001a\u00030³\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u0018\u0010·\u0001\u001a\u00030¶\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R\u0018\u0010º\u0001\u001a\u00030¹\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R\u001d\u0010½\u0001\u001a\u00030¼\u00018\u0006¢\u0006\u0010\n\u0006\b½\u0001\u0010¾\u0001\u001a\u0006\b¿\u0001\u0010À\u0001R%\u0010Ã\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Â\u00010-0Á\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R*\u0010Æ\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Â\u00010-0Å\u00018\u0006¢\u0006\u0010\n\u0006\bÆ\u0001\u0010Ç\u0001\u001a\u0006\bÈ\u0001\u0010É\u0001R.\u0010Ê\u0001\u001a\u0014\u0012\u0005\u0012\u00030Â\u00010\nj\t\u0012\u0005\u0012\u00030Â\u0001`\f8\u0006¢\u0006\u0010\n\u0006\bÊ\u0001\u0010Ë\u0001\u001a\u0006\bÌ\u0001\u0010Í\u0001R\u0019\u0010Î\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001R\u0018\u0010Ñ\u0001\u001a\u00030Ð\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R$\u0010Ô\u0001\u001a\n\u0012\u0005\u0012\u00030Ó\u00010Å\u00018\u0006¢\u0006\u0010\n\u0006\bÔ\u0001\u0010Ç\u0001\u001a\u0006\bÕ\u0001\u0010É\u0001R!\u0010×\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010Ö\u00010Á\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b×\u0001\u0010Ä\u0001R&\u0010Ø\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010Ö\u00010Å\u00018\u0006¢\u0006\u0010\n\u0006\bØ\u0001\u0010Ç\u0001\u001a\u0006\bÙ\u0001\u0010É\u0001R/\u0010Ú\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010R0-8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bÚ\u0001\u0010Û\u0001\u001a\u0005\bÜ\u0001\u0010{\"\u0005\bÝ\u0001\u0010\\R\u001e\u0010Þ\u0001\u001a\t\u0012\u0004\u0012\u00020$0Á\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÞ\u0001\u0010Ä\u0001R!\u0010[\u001a\t\u0012\u0004\u0012\u00020$0Å\u00018\u0006¢\u0006\u000f\n\u0005\b[\u0010Ç\u0001\u001a\u0006\bß\u0001\u0010É\u0001R\u0019\u0010à\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bà\u0001\u0010á\u0001R'\u0010ã\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020w0â\u00010Á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bã\u0001\u0010Ä\u0001R*\u0010ä\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020w0â\u00010Å\u00018\u0006¢\u0006\u0010\n\u0006\bä\u0001\u0010Ç\u0001\u001a\u0006\bå\u0001\u0010É\u0001R\u0018\u0010æ\u0001\u001a\u00030¹\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bæ\u0001\u0010»\u0001R#\u0010è\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040ç\u00018\u0006¢\u0006\u0010\n\u0006\bè\u0001\u0010é\u0001\u001a\u0006\bê\u0001\u0010ë\u0001R\u0018\u0010ì\u0001\u001a\u00030¹\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bì\u0001\u0010»\u0001R(\u0010í\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0Q0P8\u0006¢\u0006\u0010\n\u0006\bí\u0001\u0010î\u0001\u001a\u0006\bï\u0001\u0010ð\u0001R(\u0010ñ\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0Q0P8\u0006¢\u0006\u0010\n\u0006\bñ\u0001\u0010î\u0001\u001a\u0006\bò\u0001\u0010ð\u0001R)\u0010ô\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030ó\u00010Q0P8\u0006¢\u0006\u0010\n\u0006\bô\u0001\u0010î\u0001\u001a\u0006\bõ\u0001\u0010ð\u0001¨\u0006ö\u0001"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chat/component/ChatViewModel;", "Lcu/todus/android/viewModel/ToDusViewModel;", "<init>", "()V", "", "uid", "Lua/k0;", "loadMentionList", "(Ljava/lang/String;Lab/e;)Ljava/lang/Object;", "msgContent", "Ljava/util/ArrayList;", "Lcu/todus/android/data/db/pojo/messageentity/MentionName;", "Lkotlin/collections/ArrayList;", "getMentions", "(Ljava/lang/String;)Ljava/util/ArrayList;", "Lcu/todus/android/data/db/entity/toDus/Room;", MarkerAction.COLUMN_ROOM, "Ljava/io/File;", ExtensionFile.ELEMENT, "", "time", "replyMsg", "sendVoice", "(Lcu/todus/android/data/db/entity/toDus/Room;Ljava/io/File;ILjava/lang/String;Lab/e;)Ljava/lang/Object;", "reloadChatData", "(Ljava/lang/String;)V", "Lcu/todus/android/data/preferences/Owner;", "getOwner", "()Lcu/todus/android/data/preferences/Owner;", "mentionName", "Lkotlin/Function1;", "onLoaded", "Lkotlin/Function0;", "onError", "goChatByMention", "(Lcu/todus/android/data/db/pojo/messageentity/MentionName;Lkotlin/jvm/functions/Function1;Llb/a;)V", "", "b", "sendTyping", "(Z)V", Room.COLUMN_LAST_MSG, "tryResend", "text", "roomId", "removeForAll", "", "messageList", "msgIdForEdit", "msgPubIdForEdit", "sendMessage", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "files", "content", "sendImages", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "sendFiles", "sendVideos", "sendAudios", "Lcu/todus/android/data/db/pojo/content/ContactContent;", "contactContent", "sendContact", "(Ljava/lang/String;Lcu/todus/android/data/db/pojo/content/ContactContent;Ljava/lang/String;)V", "Lcu/todus/android/data/db/entity/toDus/Sticker;", "sticker", "sendSticker", "(Ljava/lang/String;Lcu/todus/android/data/db/entity/toDus/Sticker;Ljava/lang/String;)V", "id", "startRecorder", "(Ljava/lang/String;)Ljava/io/File;", "stopRecorder", "()Ljava/io/File;", "stopRecorderAndSend", "loadChatState", "input", "setRoomDraft", "(Ljava/lang/String;Ljava/lang/String;)V", "clearRoomDraft", "pinMsgInGroup", "unPinMsgInGroup", "loadChatMsgsFlow", "Lte/h;", "Landroidx/paging/PagingData;", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "chatMsgs", "(Ljava/lang/String;)Lte/h;", "Lcu/todus/android/data/db/entity/toDus/Message;", "msg", "displaySingleMsgRead", "(Lcu/todus/android/data/db/entity/toDus/Message;)V", "displayAllMsg", Service.Endpoint.LINKED_DEVICES_LIST, "allMsgsAreMine", "(Ljava/util/List;)V", "deleteMessages", "deleteForAll", "(Ljava/lang/String;Ljava/util/List;)V", "msgIds", "share", "messageItemView", "loadLinkInfo", "(Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;)V", TemplateContent.NUMBER_TYPE, "name", "whoSendIt", "requestUserByContact", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "readRequestingFriend", "requestLast", "Lcu/todus/android/media/player/MediaPlayerData;", "mpd", "Landroid/content/Context;", "context", "startPlaying", "(Lcu/todus/android/media/player/MediaPlayerData;Landroid/content/Context;)V", "stopPlaying", "onCompleted", Room.CONFIG_SUBSCRIBED_STATE, "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "filter", "Lcu/todus/android/data/db/pojo/Friend;", "friendsOnDbNoHeaders", "Lcu/todus/android/data/db/entity/cache/BotShortcut;", "getAttachmentShortcuts", "()Ljava/util/List;", "onComplete", "leaveAndDeleteCard", "loadChannelOldMsgs", "pubIds", "chId", "reloadSelectedMsgsOnChannel", "(Ljava/util/List;Ljava/lang/String;)V", "pastToClipboard", "(Ljava/util/List;Landroid/content/Context;)V", AppMeasurementSdk.ConditionalUserProperty.VALUE, "onReacted", "onChangeStickerFavoriteStatus", "(Ljava/lang/String;Z)V", "path", "setChatBackground", "removeChatBackground", "setUnknownRoomAsAccepted", "setUnknownRoomAsRejected", "(Ljava/lang/String;Llb/a;)V", "setUnknownUserAsBlocked", "setUnknownUserAsShared", "statusId", "Lkotlin/Pair;", "onFound", "getStatusPosition", "onStarted", "startCall", "startAudioCallNew", "startVideoCallNew", "Lcu/todus/android/di/MediaModule;", "mediaModule", "Lcu/todus/android/di/MediaModule;", "Lcu/todus/android/di/PreferencesModule;", "preferencesModule", "Lcu/todus/android/di/PreferencesModule;", "Lcu/todus/android/notification/NotificationManager;", "notificationManager", "Lcu/todus/android/notification/NotificationManager;", "getNotificationManager", "()Lcu/todus/android/notification/NotificationManager;", "Lcu/todus/android/repositories/MainRepository;", "mainRepository", "Lcu/todus/android/repositories/MainRepository;", "Lcu/todus/android/repositories/RoomsRepository;", "roomsRepository", "Lcu/todus/android/repositories/RoomsRepository;", "Lcu/todus/android/repositories/StickersRepository;", "stickersRepository", "Lcu/todus/android/repositories/StickersRepository;", "Lcu/todus/android/repositories/UsersRepository;", "usersRepository", "Lcu/todus/android/repositories/UsersRepository;", "Lcu/todus/android/repositories/BotShortcutRepository;", "botShortcutRepository", "Lcu/todus/android/repositories/BotShortcutRepository;", "Lcu/todus/android/repositories/StatusRepository;", "statusRepository", "Lcu/todus/android/repositories/StatusRepository;", "Lcu/todus/android/volatileState/AppVolatileState;", "appVolatileState", "Lcu/todus/android/volatileState/AppVolatileState;", "Landroidx/paging/PagingConfig;", "messagePagingConfig", "Landroidx/paging/PagingConfig;", "Lv5/f;", "gson", "Lv5/f;", "getGson", "()Lv5/f;", "Lte/b0;", "Lcu/todus/android/uiCompose/main/screen/chat/mentionList/MentionItemModel;", "_mentionList", "Lte/b0;", "Lte/p0;", "mentionList", "Lte/p0;", "getMentionList", "()Lte/p0;", "actualMentionsToSend", "Ljava/util/ArrayList;", "getActualMentionsToSend", "()Ljava/util/ArrayList;", "canSendTyping", "Z", "cu/todus/android/uiCompose/main/screen/chat/component/ChatViewModel$timer$1", "timer", "Lcu/todus/android/uiCompose/main/screen/chat/component/ChatViewModel$timer$1;", "", "recordingTime", "getRecordingTime", "Lcu/todus/android/uiCompose/main/screen/chat/component/ChatScreenState;", "_chatScreenState", "chatScreenState", "getChatScreenState", "msgList", "Ljava/util/List;", "getMsgList", "setMsgList", "_allMsgsAreMine", "getAllMsgsAreMine", "loadingLink", "Ljava/lang/String;", "Lcu/todus/android/data/wrapper/FlowsState;", "_requestingFriend", "requestingFriend", "getRequestingFriend", "contactsPagingConfig", "Lcu/z17/views/utils/Z17MutableListFlow;", "refreshing", "Lcu/z17/views/utils/Z17MutableListFlow;", "getRefreshing", "()Lcu/z17/views/utils/Z17MutableListFlow;", "stickerPagingConfig", "favoriteStickers", "Lte/h;", "getFavoriteStickers", "()Lte/h;", "recentStickers", "getRecentStickers", "Lcu/todus/android/data/db/pojo/StickerGroup;", "allStickers", "getAllStickers", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ChatViewModel extends ToDusViewModel {
    public static final int $stable = 8;
    private final b0 _allMsgsAreMine;
    private final b0 _chatScreenState;
    private final b0 _mentionList;
    private b0 _requestingFriend;
    private final ArrayList<MentionItemModel> actualMentionsToSend;
    private final p0 allMsgsAreMine;
    private final te.h allStickers;
    private final AppVolatileState appVolatileState;
    private final BotShortcutRepository botShortcutRepository;
    private boolean canSendTyping;
    private final p0 chatScreenState;
    private final PagingConfig contactsPagingConfig;
    private final te.h favoriteStickers;
    private final v5.f gson;
    private String loadingLink;
    private final MainRepository mainRepository;
    private final MediaModule mediaModule;
    private final p0 mentionList;
    private final PagingConfig messagePagingConfig;
    private List<MessageWithPartnerWithReactions> msgList;
    private final NotificationManager notificationManager;
    private final PreferencesModule preferencesModule;
    private final te.h recentStickers;
    private final p0 recordingTime;
    private final Z17MutableListFlow<String> refreshing;
    private final p0 requestingFriend;
    private final RoomsRepository roomsRepository;
    private final StatusRepository statusRepository;
    private final PagingConfig stickerPagingConfig;
    private final StickersRepository stickersRepository;
    private final ChatViewModel$timer$1 timer;
    private final UsersRepository usersRepository;

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$allMsgsAreMine$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$allMsgsAreMine$1", f = "ChatViewModel.kt", l = {651}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass1 extends cb.m implements Function1 {
        final /* synthetic */ List<String> $list;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List<String> list, ab.e<? super AnonymousClass1> eVar) {
            super(1, eVar);
            this.$list = list;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new AnonymousClass1(this.$list, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((AnonymousClass1) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            b0 b0Var;
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                b0 b0Var2 = ChatViewModel.this._allMsgsAreMine;
                MainRepository mainRepository = ChatViewModel.this.mainRepository;
                List<String> list = this.$list;
                this.L$0 = b0Var2;
                this.label = 1;
                Object objAllSentMsgsAreMine = mainRepository.allSentMsgsAreMine(list, this);
                if (objAllSentMsgsAreMine == objG) {
                    return objG;
                }
                b0Var = b0Var2;
                obj = objAllSentMsgsAreMine;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b0Var = (b0) this.L$0;
                v.b(obj);
            }
            b0Var.setValue(obj);
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$clearRoomDraft$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$clearRoomDraft$1", f = "ChatViewModel.kt", l = {509}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12081 extends cb.m implements Function1 {
        final /* synthetic */ String $roomId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12081(String str, ab.e<? super C12081> eVar) {
            super(1, eVar);
            this.$roomId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12081(this.$roomId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12081) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                RoomsRepository roomsRepository = ChatViewModel.this.roomsRepository;
                String str = this.$roomId;
                this.label = 1;
                if (roomsRepository.updateDraftState("", str, this) == objG) {
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
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$deleteForAll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$deleteForAll$1", f = "ChatViewModel.kt", l = {664, 671}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12091 extends cb.m implements Function1 {
        final /* synthetic */ List<String> $list;
        final /* synthetic */ String $uid;
        int label;
        final /* synthetic */ ChatViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12091(String str, ChatViewModel chatViewModel, List<String> list, ab.e<? super C12091> eVar) {
            super(1, eVar);
            this.$uid = str;
            this.this$0 = chatViewModel;
            this.$list = list;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return new C12091(this.$uid, this.this$0, this.$list, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12091) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:
        
            if (cu.todus.android.repositories.MainRepository.sendMessageToChannel$default(r0, "", null, r3, null, null, true, r7, null, r13, androidx.media3.muxer.WebmConstants.MkvEbmlElement.FLAG_INTERLACED, null) == r12) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0060, code lost:
        
            if (cu.todus.android.repositories.MainRepository.sendMessage$default(r0, "", null, r3, null, null, true, r7, r13, 26, null) == r12) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0062, code lost:
        
            return r12;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r12 = bb.b.g()
                int r0 = r13.label
                r1 = 2
                r2 = 1
                if (r0 == 0) goto L1b
                if (r0 == r2) goto L17
                if (r0 != r1) goto Lf
                goto L17
            Lf:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L17:
                ua.v.b(r14)
                goto L63
            L1b:
                ua.v.b(r14)
                cu.todus.android.xmpp.XMPPUtils r0 = cu.todus.android.xmpp.XMPPUtils.INSTANCE
                java.lang.String r3 = r13.$uid
                boolean r0 = r0.isChannel(r3)
                if (r0 == 0) goto L46
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r0 = r13.this$0
                cu.todus.android.repositories.MainRepository r0 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getMainRepository$p(r0)
                java.lang.String r3 = r13.$uid
                java.util.List<java.lang.String> r7 = r13.$list
                r13.label = r2
                java.lang.String r1 = ""
                r2 = 0
                r4 = 0
                r5 = 0
                r6 = 1
                r8 = 0
                r10 = 154(0x9a, float:2.16E-43)
                r11 = 0
                r9 = r13
                java.lang.Object r0 = cu.todus.android.repositories.MainRepository.sendMessageToChannel$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                if (r0 != r12) goto L63
                goto L62
            L46:
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r0 = r13.this$0
                cu.todus.android.repositories.MainRepository r0 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getMainRepository$p(r0)
                java.lang.String r3 = r13.$uid
                java.util.List<java.lang.String> r7 = r13.$list
                r13.label = r1
                java.lang.String r1 = ""
                r2 = 0
                r4 = 0
                r5 = 0
                r6 = 1
                r9 = 26
                r10 = 0
                r8 = r13
                java.lang.Object r0 = cu.todus.android.repositories.MainRepository.sendMessage$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
                if (r0 != r12) goto L63
            L62:
                return r12
            L63:
                ua.k0 r0 = ua.k0.f43947a
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.C12091.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$deleteMessages$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$deleteMessages$1", f = "ChatViewModel.kt", l = {657}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12101 extends cb.m implements Function1 {
        final /* synthetic */ List<String> $list;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12101(List<String> list, ab.e<? super C12101> eVar) {
            super(1, eVar);
            this.$list = list;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12101(this.$list, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12101) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = ChatViewModel.this.mainRepository;
                List<String> list = this.$list;
                this.label = 1;
                if (mainRepository.deleteMessages(list, this) == objG) {
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
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$displayAllMsg$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$displayAllMsg$1", f = "ChatViewModel.kt", l = {639}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12111 extends cb.m implements Function1 {
        final /* synthetic */ String $roomId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12111(String str, ab.e<? super C12111> eVar) {
            super(1, eVar);
            this.$roomId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12111(this.$roomId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12111) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = ChatViewModel.this.mainRepository;
                String str = this.$roomId;
                this.label = 1;
                if (mainRepository.displayAllMessages(str, this) == objG) {
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
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$displaySingleMsgRead$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$displaySingleMsgRead$1", f = "ChatViewModel.kt", l = {633}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12121 extends cb.m implements Function1 {
        final /* synthetic */ Message $msg;
        int label;
        final /* synthetic */ ChatViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12121(Message message, ChatViewModel chatViewModel, ab.e<? super C12121> eVar) {
            super(1, eVar);
            this.$msg = message;
            this.this$0 = chatViewModel;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return new C12121(this.$msg, this.this$0, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12121) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                if (this.$msg.getState() != 3 && !y.d(this.$msg.getUserSender(), this.this$0.getOwner().getNameWithDomain())) {
                    MainRepository mainRepository = this.this$0.mainRepository;
                    Message message = this.$msg;
                    this.label = 1;
                    if (mainRepository.displaySingleMsgRead(message, this) == objG) {
                        return objG;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$getStatusPosition$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$getStatusPosition$1", f = "ChatViewModel.kt", l = {988}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12131 extends cb.m implements Function1 {
        final /* synthetic */ Function1 $onFound;
        final /* synthetic */ String $statusId;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$getStatusPosition$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$getStatusPosition$1$1", f = "ChatViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02191 extends cb.m implements Function2 {
            final /* synthetic */ Function1 $onFound;
            final /* synthetic */ Pair<Boolean, Integer> $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02191(Function1 function1, Pair<Boolean, Integer> pair, ab.e<? super C02191> eVar) {
                super(2, eVar);
                this.$onFound = function1;
                this.$result = pair;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02191(this.$onFound, this.$result, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onFound.invoke(this.$result);
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02191) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12131(String str, Function1 function1, ab.e<? super C12131> eVar) {
            super(1, eVar);
            this.$statusId = str;
            this.$onFound = function1;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12131(this.$statusId, this.$onFound, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12131) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                StatusRepository statusRepository = ChatViewModel.this.statusRepository;
                String str = this.$statusId;
                this.label = 1;
                obj = statusRepository.getPositionById(str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            pe.k.d(ViewModelKt.getViewModelScope(ChatViewModel.this), d1.c(), null, new C02191(this.$onFound, (Pair) obj, null), 2, null);
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$goChatByMention$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$goChatByMention$1", f = "ChatViewModel.kt", l = {142, 144, WebmConstants.MkvEbmlElement.BLOCK_MORE, 168, 194}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12141 extends cb.m implements Function1 {
        final /* synthetic */ MentionName $mentionName;
        final /* synthetic */ lb.a $onError;
        final /* synthetic */ Function1 $onLoaded;
        int label;
        final /* synthetic */ ChatViewModel this$0;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$goChatByMention$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$goChatByMention$1$1", f = "ChatViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02201 extends cb.m implements Function2 {
            final /* synthetic */ Function1 $onLoaded;
            final /* synthetic */ ChatParams $params;
            int label;
            final /* synthetic */ ChatViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02201(Function1 function1, ChatViewModel chatViewModel, ChatParams chatParams, ab.e<? super C02201> eVar) {
                super(2, eVar);
                this.$onLoaded = function1;
                this.this$0 = chatViewModel;
                this.$params = chatParams;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02201(this.$onLoaded, this.this$0, this.$params, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                Function1 function1 = this.$onLoaded;
                NavLinks navLinks = NavLinks.INSTANCE;
                String strT = this.this$0.getGson().t(this.$params);
                y.h(strT, "toJson(...)");
                function1.invoke(navLinks.goChat(0, strT));
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02201) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$goChatByMention$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$goChatByMention$1$2", f = "ChatViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass2 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onError;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(lb.a aVar, ab.e<? super AnonymousClass2> eVar) {
                super(2, eVar);
                this.$onError = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass2(this.$onError, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onError.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$goChatByMention$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$goChatByMention$1$3", f = "ChatViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass3 extends cb.m implements Function2 {
            final /* synthetic */ Function1 $onLoaded;
            final /* synthetic */ ChatParams $params;
            int label;
            final /* synthetic */ ChatViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(Function1 function1, ChatViewModel chatViewModel, ChatParams chatParams, ab.e<? super AnonymousClass3> eVar) {
                super(2, eVar);
                this.$onLoaded = function1;
                this.this$0 = chatViewModel;
                this.$params = chatParams;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass3(this.$onLoaded, this.this$0, this.$params, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                Function1 function1 = this.$onLoaded;
                NavLinks navLinks = NavLinks.INSTANCE;
                String strT = this.this$0.getGson().t(this.$params);
                y.h(strT, "toJson(...)");
                function1.invoke(navLinks.goChat(3, strT));
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass3) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$goChatByMention$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$goChatByMention$1$4", f = "ChatViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass4 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onError;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass4(lb.a aVar, ab.e<? super AnonymousClass4> eVar) {
                super(2, eVar);
                this.$onError = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass4(this.$onError, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onError.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass4) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$goChatByMention$1$5, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$goChatByMention$1$5", f = "ChatViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass5 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onError;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass5(lb.a aVar, ab.e<? super AnonymousClass5> eVar) {
                super(2, eVar);
                this.$onError = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass5(this.$onError, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onError.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass5) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$goChatByMention$1$6, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$goChatByMention$1$6", f = "ChatViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass6 extends cb.m implements Function2 {
            final /* synthetic */ Function1 $onLoaded;
            final /* synthetic */ ChatParams $params;
            int label;
            final /* synthetic */ ChatViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass6(Function1 function1, ChatViewModel chatViewModel, ChatParams chatParams, ab.e<? super AnonymousClass6> eVar) {
                super(2, eVar);
                this.$onLoaded = function1;
                this.this$0 = chatViewModel;
                this.$params = chatParams;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass6(this.$onLoaded, this.this$0, this.$params, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                Function1 function1 = this.$onLoaded;
                NavLinks navLinks = NavLinks.INSTANCE;
                String strT = this.this$0.getGson().t(this.$params);
                y.h(strT, "toJson(...)");
                function1.invoke(navLinks.goChat(0, strT));
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass6) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$goChatByMention$1$7, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$goChatByMention$1$7", f = "ChatViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass7 extends cb.m implements Function2 {
            final /* synthetic */ Function1 $onLoaded;
            final /* synthetic */ ChatParams $params;
            int label;
            final /* synthetic */ ChatViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass7(Function1 function1, ChatViewModel chatViewModel, ChatParams chatParams, ab.e<? super AnonymousClass7> eVar) {
                super(2, eVar);
                this.$onLoaded = function1;
                this.this$0 = chatViewModel;
                this.$params = chatParams;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass7(this.$onLoaded, this.this$0, this.$params, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                Function1 function1 = this.$onLoaded;
                NavLinks navLinks = NavLinks.INSTANCE;
                String strT = this.this$0.getGson().t(this.$params);
                y.h(strT, "toJson(...)");
                function1.invoke(navLinks.goChat(3, strT));
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass7) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$goChatByMention$1$8, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$goChatByMention$1$8", f = "ChatViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass8 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onError;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass8(lb.a aVar, ab.e<? super AnonymousClass8> eVar) {
                super(2, eVar);
                this.$onError = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass8(this.$onError, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onError.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass8) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$goChatByMention$1$9, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$goChatByMention$1$9", f = "ChatViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass9 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onError;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass9(lb.a aVar, ab.e<? super AnonymousClass9> eVar) {
                super(2, eVar);
                this.$onError = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass9(this.$onError, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onError.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass9) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12141(MentionName mentionName, ChatViewModel chatViewModel, lb.a aVar, Function1 function1, ab.e<? super C12141> eVar) {
            super(1, eVar);
            this.$mentionName = mentionName;
            this.this$0 = chatViewModel;
            this.$onError = aVar;
            this.$onLoaded = function1;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return new C12141(this.$mentionName, this.this$0, this.$onError, this.$onLoaded, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12141) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x00a0, code lost:
        
            if (r2 == r1) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0113, code lost:
        
            if (r2 == r1) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x017e, code lost:
        
            if (r2 == r1) goto L48;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                Method dump skipped, instruction units count: 543
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.C12141.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$leaveAndDeleteCard$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$leaveAndDeleteCard$1", f = "ChatViewModel.kt", l = {809}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12151 extends cb.m implements Function1 {
        final /* synthetic */ Function1 $onComplete;
        final /* synthetic */ String $uid;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$leaveAndDeleteCard$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$leaveAndDeleteCard$1$1", f = "ChatViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02211 extends cb.m implements Function2 {
            final /* synthetic */ Function1 $onComplete;
            final /* synthetic */ boolean $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02211(Function1 function1, boolean z10, ab.e<? super C02211> eVar) {
                super(2, eVar);
                this.$onComplete = function1;
                this.$result = z10;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02211(this.$onComplete, this.$result, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onComplete.invoke(cb.b.a(this.$result));
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02211) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12151(String str, Function1 function1, ab.e<? super C12151> eVar) {
            super(1, eVar);
            this.$uid = str;
            this.$onComplete = function1;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12151(this.$uid, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12151) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = ChatViewModel.this.mainRepository;
                String str = this.$uid;
                this.label = 1;
                obj = mainRepository.unsubscribeCard(str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            pe.k.d(ViewModelKt.getViewModelScope(ChatViewModel.this), d1.c(), null, new C02211(this.$onComplete, ((Boolean) obj).booleanValue(), null), 2, null);
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$loadChannelOldMsgs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$loadChannelOldMsgs$1", f = "ChatViewModel.kt", l = {823}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12161 extends cb.m implements Function1 {
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12161(String str, ab.e<? super C12161> eVar) {
            super(1, eVar);
            this.$uid = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12161(this.$uid, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12161) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = ChatViewModel.this.mainRepository;
                String str = this.$uid;
                this.label = 1;
                if (mainRepository.requestChannelMessages(str, this) == objG) {
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
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$loadChatMsgsFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$loadChatMsgsFlow$1", f = "ChatViewModel.kt", l = {545}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C12171 extends cb.m implements Function2 {
        final /* synthetic */ String $uid;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$loadChatMsgsFlow$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$loadChatMsgsFlow$1$1", f = "ChatViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcu/todus/android/data/db/pojo/MessageWithPartnerWithReactions;", "it", "Lua/k0;", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02221 extends cb.m implements Function2 {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ChatViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02221(ChatViewModel chatViewModel, ab.e<? super C02221> eVar) {
                super(2, eVar);
                this.this$0 = chatViewModel;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                C02221 c02221 = new C02221(this.this$0, eVar);
                c02221.L$0 = obj;
                return c02221;
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                List<MessageWithPartnerWithReactions> list = (List) this.L$0;
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.this$0.setMsgList(list);
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(List<MessageWithPartnerWithReactions> list, ab.e<? super k0> eVar) {
                return ((C02221) create(list, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12171(String str, ab.e<? super C12171> eVar) {
            super(2, eVar);
            this.$uid = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return ChatViewModel.this.new C12171(this.$uid, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                te.h hVarF = te.j.f(ChatViewModel.this.mainRepository.getMsgsByRoomId(this.$uid));
                C02221 c02221 = new C02221(ChatViewModel.this, null);
                this.label = 1;
                if (te.j.k(hVarF, c02221, this) == objG) {
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
            return ((C12171) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$loadChatState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$loadChatState$1", f = "ChatViewModel.kt", l = {474}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C12181 extends cb.m implements Function2 {
        final /* synthetic */ String $id;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$loadChatState$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$loadChatState$1$1", f = "ChatViewModel.kt", l = {479}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcu/todus/android/uiCompose/main/screen/chat/component/ChatScreenState;", "newChatState", "Lua/k0;", "<anonymous>", "(Lcu/todus/android/uiCompose/main/screen/chat/component/ChatScreenState;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02231 extends cb.m implements Function2 {
            final /* synthetic */ String $id;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ChatViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02231(ChatViewModel chatViewModel, String str, ab.e<? super C02231> eVar) {
                super(2, eVar);
                this.this$0 = chatViewModel;
                this.$id = str;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                C02231 c02231 = new C02231(this.this$0, this.$id, eVar);
                c02231.L$0 = obj;
                return c02231;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(ChatScreenState chatScreenState, ab.e<? super k0> eVar) {
                return ((C02231) create(chatScreenState, eVar)).invokeSuspend(k0.f43947a);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                ChatScreenState chatScreenState = (ChatScreenState) this.L$0;
                Object objG = bb.b.g();
                int i10 = this.label;
                if (i10 == 0) {
                    v.b(obj);
                    if (chatScreenState != null) {
                        this.this$0._chatScreenState.setValue(chatScreenState);
                        if (XMPPUtils.INSTANCE.isMUC(this.$id)) {
                            ChatViewModel chatViewModel = this.this$0;
                            String str = this.$id;
                            this.L$0 = cb.l.a(chatScreenState);
                            this.label = 1;
                            if (chatViewModel.loadMentionList(str, this) == objG) {
                                return objG;
                            }
                        }
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.b(obj);
                }
                return k0.f43947a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12181(String str, ab.e<? super C12181> eVar) {
            super(2, eVar);
            this.$id = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return ChatViewModel.this.new C12181(this.$id, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) throws Exception {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                te.h hVarChatState = ChatViewModel.this.roomsRepository.chatState(this.$id, (ChatScreenState) ChatViewModel.this.getChatScreenState().getValue());
                C02231 c02231 = new C02231(ChatViewModel.this, this.$id, null);
                this.label = 1;
                if (te.j.k(hVarChatState, c02231, this) == objG) {
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
            return ((C12181) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$loadChatState$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$loadChatState$2", f = "ChatViewModel.kt", l = {485}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class AnonymousClass2 extends cb.m implements Function2 {
        final /* synthetic */ String $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, ab.e<? super AnonymousClass2> eVar) {
            super(2, eVar);
            this.$id = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return ChatViewModel.this.new AnonymousClass2(this.$id, eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                this.label = 1;
                if (w0.b(2000L, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            if (ChatViewModel.this.appVolatileState.getOwnerConnection() != Quality.BAD_QUALITY) {
                ChatViewModel.this.reloadChatData(this.$id);
            }
            return k0.f43947a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((AnonymousClass2) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$loadLinkInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$loadLinkInfo$1", f = "ChatViewModel.kt", l = {698, 710}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C12191 extends cb.m implements Function2 {
        final /* synthetic */ MessageWithPartnerWithReactions $messageItemView;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ ChatViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12191(MessageWithPartnerWithReactions messageWithPartnerWithReactions, ChatViewModel chatViewModel, ab.e<? super C12191> eVar) {
            super(2, eVar);
            this.$messageItemView = messageWithPartnerWithReactions;
            this.this$0 = chatViewModel;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            return new C12191(this.$messageItemView, this.this$0, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x010a, code lost:
        
            if (r7.updateAttachment(r5, r18) == r1) goto L35;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instruction units count: 285
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.C12191.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C12191) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$loadMentionList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel", f = "ChatViewModel.kt", l = {99}, m = "loadMentionList", v = 2)
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class C12201 extends cb.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C12201(ab.e<? super C12201> eVar) {
            super(eVar);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChatViewModel.this.loadMentionList(null, this);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$onChangeStickerFavoriteStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$onChangeStickerFavoriteStatus$1", f = "ChatViewModel.kt", l = {912}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12211 extends cb.m implements Function1 {
        final /* synthetic */ String $id;
        final /* synthetic */ boolean $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12211(String str, boolean z10, ab.e<? super C12211> eVar) {
            super(1, eVar);
            this.$id = str;
            this.$value = z10;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12211(this.$id, this.$value, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12211) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                StickersRepository stickersRepository = ChatViewModel.this.stickersRepository;
                String str = this.$id;
                boolean z10 = this.$value;
                this.label = 1;
                if (stickersRepository.onChangeStickerFavoriteStatus(str, z10, this) == objG) {
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
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$onReacted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$onReacted$1", f = "ChatViewModel.kt", l = {876, 878}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12221 extends cb.m implements Function1 {
        final /* synthetic */ String $msgId;
        final /* synthetic */ String $roomId;
        final /* synthetic */ String $value;
        int label;
        final /* synthetic */ ChatViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12221(String str, ChatViewModel chatViewModel, String str2, String str3, ab.e<? super C12221> eVar) {
            super(1, eVar);
            this.$value = str;
            this.this$0 = chatViewModel;
            this.$roomId = str2;
            this.$msgId = str3;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return new C12221(this.$value, this.this$0, this.$roomId, this.$msgId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12221) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
        
            if (r6.reactToMsg(r1, r2, "", r5) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
        
            if (r6.reactToMsg(r1, r3, r4, r5) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
        
            return r0;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1b
                if (r1 == r3) goto L17
                if (r1 != r2) goto Lf
                goto L17
            Lf:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L17:
                ua.v.b(r6)
                goto L52
            L1b:
                ua.v.b(r6)
                java.lang.String r6 = r5.$value
                java.lang.String r1 = "🗑️"
                boolean r6 = kotlin.jvm.internal.y.d(r6, r1)
                if (r6 == 0) goto L3d
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r6 = r5.this$0
                cu.todus.android.repositories.MainRepository r6 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getMainRepository$p(r6)
                java.lang.String r1 = r5.$roomId
                java.lang.String r2 = r5.$msgId
                r5.label = r3
                java.lang.String r3 = ""
                java.lang.Object r6 = r6.reactToMsg(r1, r2, r3, r5)
                if (r6 != r0) goto L52
                goto L51
            L3d:
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r6 = r5.this$0
                cu.todus.android.repositories.MainRepository r6 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getMainRepository$p(r6)
                java.lang.String r1 = r5.$roomId
                java.lang.String r3 = r5.$msgId
                java.lang.String r4 = r5.$value
                r5.label = r2
                java.lang.Object r6 = r6.reactToMsg(r1, r3, r4, r5)
                if (r6 != r0) goto L52
            L51:
                return r0
            L52:
                ua.k0 r6 = ua.k0.f43947a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.C12221.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$pastToClipboard$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$pastToClipboard$1", f = "ChatViewModel.kt", l = {837}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12231 extends cb.m implements Function1 {
        final /* synthetic */ Context $context;
        final /* synthetic */ List<String> $msgIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12231(List<String> list, Context context, ab.e<? super C12231> eVar) {
            super(1, eVar);
            this.$msgIds = list;
            this.$context = context;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12231(this.$msgIds, this.$context, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12231) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            boolean z10 = true;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = ChatViewModel.this.mainRepository;
                List<String> list = this.$msgIds;
                this.label = 1;
                obj = mainRepository.getMsgsByIdIn(list, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            List<MessageWithPartnerWithReactions> list2 = (List) obj;
            if (!list2.isEmpty()) {
                User senderUser = ((MessageWithPartnerWithReactions) list2.get(0)).getSenderUser();
                String uid = senderUser != null ? senderUser.getUid() : null;
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    User senderUser2 = ((MessageWithPartnerWithReactions) it.next()).getSenderUser();
                    if (!y.d(uid, senderUser2 != null ? senderUser2.getUid() : null)) {
                        z10 = false;
                    }
                }
            }
            ChatViewModel chatViewModel = ChatViewModel.this;
            Context context = this.$context;
            String str = "";
            for (MessageWithPartnerWithReactions messageWithPartnerWithReactions : list2) {
                if (!z10) {
                    str = ((Object) str) + (y.d(messageWithPartnerWithReactions.getMessage().getUserSender(), chatViewModel.getOwner().getNameWithDomain()) ? chatViewModel.getOwner().getAlias() : messageWithPartnerWithReactions.getSenderAlias()) + ": \n";
                }
                str = ((Object) str) + Domain.INSTANCE.createShorMsg(messageWithPartnerWithReactions.getMessage(), messageWithPartnerWithReactions.getAttachments(), messageWithPartnerWithReactions.getMessage().getPayload(), context, chatViewModel.getOwner().getNameWithDomain(), y.d(messageWithPartnerWithReactions.getMessage().getUserSender(), chatViewModel.getOwner().getNameWithDomain()) ? chatViewModel.getOwner().getAlias() : messageWithPartnerWithReactions.getSenderAlias()) + "\n\n";
            }
            Object systemService = this.$context.getSystemService("clipboard");
            y.g(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("msg", str));
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$pinMsgInGroup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$pinMsgInGroup$1", f = "ChatViewModel.kt", l = {517, 520}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12241 extends cb.m implements Function1 {
        final /* synthetic */ String $msgId;
        final /* synthetic */ String $roomId;
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12241(String str, String str2, ab.e<? super C12241> eVar) {
            super(1, eVar);
            this.$msgId = str;
            this.$roomId = str2;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12241(this.$msgId, this.$roomId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12241) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0083, code lost:
        
            if (r4.pinMsgInGroup(r3, r1, r5, r7) == r0) goto L17;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r7.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L26
                if (r1 == r3) goto L22
                if (r1 != r2) goto L1a
                java.lang.Object r0 = r7.L$1
                cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions r0 = (cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions) r0
                java.lang.Object r0 = r7.L$0
                cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions r0 = (cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions) r0
                ua.v.b(r8)
                goto L86
            L1a:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L22:
                ua.v.b(r8)
                goto L3a
            L26:
                ua.v.b(r8)
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r8 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.this
                cu.todus.android.repositories.MainRepository r8 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getMainRepository$p(r8)
                java.lang.String r1 = r7.$msgId
                r7.label = r3
                java.lang.Object r8 = r8.getMsgById(r1, r7)
                if (r8 != r0) goto L3a
                goto L85
            L3a:
                cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions r8 = (cu.todus.android.data.db.pojo.MessageWithPartnerWithReactions) r8
                if (r8 == 0) goto L86
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r1 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.this
                java.lang.String r3 = r7.$roomId
                cu.todus.android.repositories.MainRepository r4 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getMainRepository$p(r1)
                cu.todus.android.di.MainModule$Companion r5 = cu.todus.android.di.MainModule.INSTANCE
                java.lang.Object r5 = r5.getInstance()
                cu.todus.android.di.MainModule r5 = (cu.todus.android.di.MainModule) r5
                android.content.Context r5 = r5.getAppContext()
                cu.todus.android.data.preferences.Owner r6 = r1.getOwner()
                java.lang.String r6 = r6.getNameWithDomain()
                cu.todus.android.data.preferences.Owner r1 = r1.getOwner()
                java.lang.String r1 = r1.getAlias()
                java.lang.String r1 = cu.todus.android.utils.ExtensionFunsKt.toShortMsg(r8, r5, r6, r1)
                cu.todus.android.data.db.entity.toDus.Message r5 = r8.getMessage()
                java.lang.String r5 = r5.getId()
                java.lang.Object r6 = cb.l.a(r8)
                r7.L$0 = r6
                java.lang.Object r8 = cb.l.a(r8)
                r7.L$1 = r8
                r8 = 0
                r7.I$0 = r8
                r7.label = r2
                java.lang.Object r8 = r4.pinMsgInGroup(r3, r1, r5, r7)
                if (r8 != r0) goto L86
            L85:
                return r0
            L86:
                ua.k0 r8 = ua.k0.f43947a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.C12241.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$reloadChatData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$reloadChatData$1", f = "ChatViewModel.kt", l = {493, 494, 495, 496}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12251 extends cb.m implements Function1 {
        final /* synthetic */ String $uid;
        int label;
        final /* synthetic */ ChatViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12251(String str, ChatViewModel chatViewModel, ab.e<? super C12251> eVar) {
            super(1, eVar);
            this.$uid = str;
            this.this$0 = chatViewModel;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return new C12251(this.$uid, this.this$0, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12251) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
        
            if (r7.reloadChannel(r1, r6) == r0) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0055, code lost:
        
            if (r7.reloadGroup(r1, r6) == r0) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x006e, code lost:
        
            if (r7.reloadCard(r1, r6) == r0) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0087, code lost:
        
            if (r7.reloadUser(r1, r6) == r0) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0089, code lost:
        
            return r0;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r6.label
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L21
                if (r1 == r5) goto L1d
                if (r1 == r4) goto L1d
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                goto L1d
            L15:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1d:
                ua.v.b(r7)
                goto L8a
            L21:
                ua.v.b(r7)
                cu.todus.android.xmpp.XMPPUtils r7 = cu.todus.android.xmpp.XMPPUtils.INSTANCE
                java.lang.String r1 = r6.$uid
                boolean r1 = r7.isChannel(r1)
                if (r1 == 0) goto L3f
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r7 = r6.this$0
                cu.todus.android.repositories.MainRepository r7 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getMainRepository$p(r7)
                java.lang.String r1 = r6.$uid
                r6.label = r5
                java.lang.Object r7 = r7.reloadChannel(r1, r6)
                if (r7 != r0) goto L8a
                goto L89
            L3f:
                java.lang.String r1 = r6.$uid
                boolean r1 = r7.isMUC(r1)
                if (r1 == 0) goto L58
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r7 = r6.this$0
                cu.todus.android.repositories.MainRepository r7 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getMainRepository$p(r7)
                java.lang.String r1 = r6.$uid
                r6.label = r4
                java.lang.Object r7 = r7.reloadGroup(r1, r6)
                if (r7 != r0) goto L8a
                goto L89
            L58:
                java.lang.String r1 = r6.$uid
                boolean r1 = r7.isCard(r1)
                if (r1 == 0) goto L71
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r7 = r6.this$0
                cu.todus.android.repositories.MainRepository r7 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getMainRepository$p(r7)
                java.lang.String r1 = r6.$uid
                r6.label = r3
                java.lang.Object r7 = r7.reloadCard(r1, r6)
                if (r7 != r0) goto L8a
                goto L89
            L71:
                java.lang.String r1 = r6.$uid
                boolean r7 = r7.isUser(r1)
                if (r7 == 0) goto L8a
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r7 = r6.this$0
                cu.todus.android.repositories.MainRepository r7 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getMainRepository$p(r7)
                java.lang.String r1 = r6.$uid
                r6.label = r2
                java.lang.Object r7 = r7.reloadUser(r1, r6)
                if (r7 != r0) goto L8a
            L89:
                return r0
            L8a:
                ua.k0 r7 = ua.k0.f43947a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.C12251.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$reloadSelectedMsgsOnChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$reloadSelectedMsgsOnChannel$1", f = "ChatViewModel.kt", l = {829}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12261 extends cb.m implements Function1 {
        final /* synthetic */ String $chId;
        final /* synthetic */ List<String> $pubIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12261(List<String> list, String str, ab.e<? super C12261> eVar) {
            super(1, eVar);
            this.$pubIds = list;
            this.$chId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12261(this.$pubIds, this.$chId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12261) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = ChatViewModel.this.mainRepository;
                List<String> list = this.$pubIds;
                String str = this.$chId;
                this.label = 1;
                if (mainRepository.reloadChannelMsgs(list, str, this) == objG) {
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
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$removeChatBackground$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$removeChatBackground$1", f = "ChatViewModel.kt", l = {928}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12271 extends cb.m implements Function1 {
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12271(String str, ab.e<? super C12271> eVar) {
            super(1, eVar);
            this.$uid = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12271(this.$uid, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12271) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                RoomsRepository roomsRepository = ChatViewModel.this.roomsRepository;
                String str = this.$uid;
                this.label = 1;
                if (roomsRepository.setRoomBackground("", str, this) == objG) {
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
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$requestLast$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$requestLast$1", f = "ChatViewModel.kt", l = {767, 768}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
    public static final class C12281 extends cb.m implements Function2 {
        final /* synthetic */ String $uid;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12281(String str, ab.e<? super C12281> eVar) {
            super(2, eVar);
            this.$uid = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
            C12281 c12281 = ChatViewModel.this.new C12281(this.$uid, eVar);
            c12281.L$0 = obj;
            return c12281;
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0022  */
        /* JADX WARN: Code duplicated, block: B:13:0x0028  */
        /* JADX WARN: Code duplicated, block: B:16:0x003b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0045 -> B:11:0x0022). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // cb.a
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = r7.L$0
                pe.m0 r0 = (pe.m0) r0
                java.lang.Object r1 = bb.b.g()
                int r2 = r7.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L1f
                if (r2 == r4) goto L1b
                if (r2 != r3) goto L13
                goto L1f
            L13:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1b:
                ua.v.b(r8)
                goto L3b
            L1f:
                ua.v.b(r8)
            L22:
                boolean r8 = pe.n0.g(r0)
                if (r8 == 0) goto L48
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r8 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.this
                cu.todus.android.repositories.MainRepository r8 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getMainRepository$p(r8)
                java.lang.String r2 = r7.$uid
                r7.L$0 = r0
                r7.label = r4
                java.lang.Object r8 = r8.getLast(r2, r7)
                if (r8 != r1) goto L3b
                goto L47
            L3b:
                r7.L$0 = r0
                r7.label = r3
                r5 = 5000(0x1388, double:2.4703E-320)
                java.lang.Object r8 = pe.w0.b(r5, r7)
                if (r8 != r1) goto L22
            L47:
                return r1
            L48:
                ua.k0 r8 = ua.k0.f43947a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.C12281.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
            return ((C12281) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$requestUserByContact$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$requestUserByContact$1", f = "ChatViewModel.kt", l = {728, 732, 735}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12291 extends cb.m implements Function1 {
        final /* synthetic */ String $name;
        final /* synthetic */ String $number;
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12291(String str, String str2, ab.e<? super C12291> eVar) {
            super(1, eVar);
            this.$number = str;
            this.$name = str2;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12291(this.$number, this.$name, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12291) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x007f  */
        /* JADX WARN: Code duplicated, block: B:24:0x0098  */
        /* JADX WARN: Code duplicated, block: B:27:0x009e  */
        /* JADX WARN: Code duplicated, block: B:28:0x00ae  */
        /* JADX WARN: Code duplicated, block: B:29:0x00eb  */
        /* JADX WARN: Instruction removed from duplicated block: B:28:0x00ae, please report this as an issue */
        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            List<String> list;
            int i10;
            User user;
            Object friendById;
            User user2;
            Friend friend;
            Object objG = bb.b.g();
            int i11 = this.label;
            if (i11 == 0) {
                v.b(obj);
                PreferencesModule preferencesModule = ChatViewModel.this.preferencesModule;
                this.label = 1;
                obj = preferencesModule.getAppState(this);
                if (obj != objG) {
                }
                return objG;
            }
            if (i11 == 1) {
                v.b(obj);
            } else {
                if (i11 == 2) {
                    int i12 = this.I$0;
                    List<String> list2 = (List) this.L$0;
                    v.b(obj);
                    i10 = i12;
                    list = list2;
                    user = (User) obj;
                    if (user != null) {
                        MainRepository mainRepository = ChatViewModel.this.mainRepository;
                        String uid = user.getUid();
                        this.L$0 = list;
                        this.L$1 = user;
                        this.I$0 = i10;
                        this.label = 3;
                        friendById = mainRepository.getFriendById(uid, this);
                        if (friendById != objG) {
                            user2 = user;
                            obj = friendById;
                        }
                        return objG;
                    }
                    b0 b0Var = ChatViewModel.this._requestingFriend;
                    FlowsState.Companion companion = FlowsState.INSTANCE;
                    String str = this.$number;
                    b0Var.setValue(companion.success(new Friend(new Contact(str, str, this.$name, null, null, null, 56, null), null)));
                    return k0.f43947a;
                }
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                user2 = (User) this.L$1;
                list = (List) this.L$0;
                v.b(obj);
            }
            friend = (Friend) obj;
            if (friend != null) {
                ChatViewModel.this._requestingFriend.setValue(FlowsState.INSTANCE.success(friend));
            } else {
                ChatViewModel.this._requestingFriend.setValue(FlowsState.INSTANCE.success(new Friend(new Contact((String) g0.w0(list), g0.w0(list) + "@im.todus.cu", this.$name, null, null, null, 56, null), user2)));
            }
            return k0.f43947a;
            int countryCode = ((AppState) obj).getCountryCode();
            List<String> numberWithPrefix = NumberInlineFunctionsKt.toNumberWithPrefix(a0.O(this.$number, "+", "", false, 4, null), String.valueOf(countryCode));
            MainRepository mainRepository2 = ChatViewModel.this.mainRepository;
            this.L$0 = numberWithPrefix;
            this.I$0 = countryCode;
            this.label = 2;
            Object userInfoByNumber = mainRepository2.getUserInfoByNumber(numberWithPrefix, this);
            if (userInfoByNumber != objG) {
                list = numberWithPrefix;
                obj = userInfoByNumber;
                i10 = countryCode;
                user = (User) obj;
                if (user != null) {
                    MainRepository mainRepository3 = ChatViewModel.this.mainRepository;
                    String uid2 = user.getUid();
                    this.L$0 = list;
                    this.L$1 = user;
                    this.I$0 = i10;
                    this.label = 3;
                    friendById = mainRepository3.getFriendById(uid2, this);
                    if (friendById != objG) {
                        user2 = user;
                        obj = friendById;
                        friend = (Friend) obj;
                        if (friend != null) {
                            ChatViewModel.this._requestingFriend.setValue(FlowsState.INSTANCE.success(friend));
                        } else {
                            ChatViewModel.this._requestingFriend.setValue(FlowsState.INSTANCE.success(new Friend(new Contact((String) g0.w0(list), g0.w0(list) + "@im.todus.cu", this.$name, null, null, null, 56, null), user2)));
                        }
                    }
                } else {
                    b0 b0Var2 = ChatViewModel.this._requestingFriend;
                    FlowsState.Companion companion2 = FlowsState.INSTANCE;
                    String str2 = this.$number;
                    b0Var2.setValue(companion2.success(new Friend(new Contact(str2, str2, this.$name, null, null, null, 56, null), null)));
                }
                return k0.f43947a;
            }
            return objG;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$sendAudios$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$sendAudios$1", f = "ChatViewModel.kt", l = {380}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12301 extends cb.m implements Function1 {
        final /* synthetic */ String $content;
        final /* synthetic */ List<File> $files;
        final /* synthetic */ String $replyMsg;
        final /* synthetic */ String $roomId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C12301(String str, List<? extends File> list, String str2, String str3, ab.e<? super C12301> eVar) {
            super(1, eVar);
            this.$roomId = str;
            this.$files = list;
            this.$content = str2;
            this.$replyMsg = str3;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12301(this.$roomId, this.$files, this.$content, this.$replyMsg, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12301) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = ChatViewModel.this.mainRepository;
                String str = this.$roomId;
                List<File> list = this.$files;
                String str2 = this.$content;
                String str3 = this.$replyMsg;
                this.label = 1;
                if (mainRepository.sendAudios(str, list, str2, str3, this) == objG) {
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
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$sendContact$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$sendContact$1", f = "ChatViewModel.kt", l = {398}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12311 extends cb.m implements Function1 {
        final /* synthetic */ ContactContent $contactContent;
        final /* synthetic */ String $replyMsg;
        final /* synthetic */ String $roomId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12311(String str, ContactContent contactContent, String str2, ab.e<? super C12311> eVar) {
            super(1, eVar);
            this.$roomId = str;
            this.$contactContent = contactContent;
            this.$replyMsg = str2;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12311(this.$roomId, this.$contactContent, this.$replyMsg, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12311) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = ChatViewModel.this.mainRepository;
                String str = this.$roomId;
                ContactContent contactContent = this.$contactContent;
                String str2 = this.$replyMsg;
                this.label = 1;
                if (mainRepository.sendContact(str, contactContent, str2, this) == objG) {
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
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$sendFiles$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$sendFiles$1", f = "ChatViewModel.kt", l = {340}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12321 extends cb.m implements Function1 {
        final /* synthetic */ String $content;
        final /* synthetic */ List<File> $files;
        final /* synthetic */ String $replyMsg;
        final /* synthetic */ String $roomId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C12321(String str, List<? extends File> list, String str2, String str3, ab.e<? super C12321> eVar) {
            super(1, eVar);
            this.$roomId = str;
            this.$files = list;
            this.$content = str2;
            this.$replyMsg = str3;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12321(this.$roomId, this.$files, this.$content, this.$replyMsg, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12321) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = ChatViewModel.this.mainRepository;
                String str = this.$roomId;
                List<File> list = this.$files;
                String str2 = this.$content;
                String str3 = this.$replyMsg;
                this.label = 1;
                if (mainRepository.sendFiles(str, list, str2, str3, this) == objG) {
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
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$sendImages$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$sendImages$1", f = "ChatViewModel.kt", l = {320}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12331 extends cb.m implements Function1 {
        final /* synthetic */ String $content;
        final /* synthetic */ List<File> $files;
        final /* synthetic */ String $replyMsg;
        final /* synthetic */ String $roomId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C12331(String str, List<? extends File> list, String str2, String str3, ab.e<? super C12331> eVar) {
            super(1, eVar);
            this.$roomId = str;
            this.$files = list;
            this.$content = str2;
            this.$replyMsg = str3;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12331(this.$roomId, this.$files, this.$content, this.$replyMsg, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12331) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = ChatViewModel.this.mainRepository;
                String str = this.$roomId;
                List<File> list = this.$files;
                String str2 = this.$content;
                String str3 = this.$replyMsg;
                this.label = 1;
                if (mainRepository.sendImages(str, list, str2, str3, this) == objG) {
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
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$sendMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$sendMessage$1", f = "ChatViewModel.kt", l = {284, 295}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12341 extends cb.m implements Function1 {
        final /* synthetic */ List<String> $messageList;
        final /* synthetic */ String $msgIdForEdit;
        final /* synthetic */ String $msgPubIdForEdit;
        final /* synthetic */ boolean $removeForAll;
        final /* synthetic */ String $replyMsg;
        final /* synthetic */ String $roomId;
        final /* synthetic */ String $safeText;
        int label;
        final /* synthetic */ ChatViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12341(String str, ChatViewModel chatViewModel, String str2, String str3, String str4, boolean z10, List<String> list, String str5, ab.e<? super C12341> eVar) {
            super(1, eVar);
            this.$roomId = str;
            this.this$0 = chatViewModel;
            this.$safeText = str2;
            this.$replyMsg = str3;
            this.$msgIdForEdit = str4;
            this.$removeForAll = z10;
            this.$messageList = list;
            this.$msgPubIdForEdit = str5;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return new C12341(this.$roomId, this.this$0, this.$safeText, this.$replyMsg, this.$msgIdForEdit, this.$removeForAll, this.$messageList, this.$msgPubIdForEdit, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12341) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x004d, code lost:
        
            if (r15 == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0072, code lost:
        
            if (r1.sendMessage(r2, r3, r4, r5, r6, r7, r8, r9) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0074, code lost:
        
            return r0;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r14.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1c
                if (r1 == r3) goto L17
                if (r1 != r2) goto Lf
                goto L17
            Lf:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L17:
                ua.v.b(r15)
                r9 = r14
                goto L75
            L1c:
                ua.v.b(r15)
                cu.todus.android.xmpp.XMPPUtils r15 = cu.todus.android.xmpp.XMPPUtils.INSTANCE
                java.lang.String r1 = r14.$roomId
                boolean r15 = r15.isChannel(r1)
                if (r15 == 0) goto L50
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r15 = r14.this$0
                cu.todus.android.repositories.MainRepository r4 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getMainRepository$p(r15)
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r15 = r14.this$0
                java.lang.String r1 = r14.$safeText
                java.util.ArrayList r6 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getMentions(r15, r1)
                java.lang.String r5 = r14.$safeText
                java.lang.String r7 = r14.$roomId
                java.lang.String r8 = r14.$replyMsg
                java.lang.String r9 = r14.$msgIdForEdit
                boolean r10 = r14.$removeForAll
                java.util.List<java.lang.String> r11 = r14.$messageList
                java.lang.String r12 = r14.$msgPubIdForEdit
                r14.label = r3
                r13 = r14
                java.lang.Object r15 = r4.sendMessageToChannel(r5, r6, r7, r8, r9, r10, r11, r12, r13)
                r9 = r13
                if (r15 != r0) goto L75
                goto L74
            L50:
                r9 = r14
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r15 = r9.this$0
                cu.todus.android.repositories.MainRepository r1 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getMainRepository$p(r15)
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r15 = r9.this$0
                java.lang.String r3 = r9.$safeText
                java.util.ArrayList r3 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getMentions(r15, r3)
                r15 = r2
                java.lang.String r2 = r9.$safeText
                java.lang.String r4 = r9.$roomId
                java.lang.String r5 = r9.$replyMsg
                java.lang.String r6 = r9.$msgIdForEdit
                boolean r7 = r9.$removeForAll
                java.util.List<java.lang.String> r8 = r9.$messageList
                r9.label = r15
                java.lang.Object r15 = r1.sendMessage(r2, r3, r4, r5, r6, r7, r8, r9)
                if (r15 != r0) goto L75
            L74:
                return r0
            L75:
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r15 = r9.this$0
                java.util.ArrayList r15 = r15.getActualMentionsToSend()
                r15.clear()
                ua.k0 r15 = ua.k0.f43947a
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.C12341.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$sendSticker$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$sendSticker$1", f = "ChatViewModel.kt", l = {430}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12351 extends cb.m implements Function1 {
        final /* synthetic */ String $replyMsg;
        final /* synthetic */ String $roomId;
        final /* synthetic */ Sticker $sticker;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12351(String str, String str2, Sticker sticker, ab.e<? super C12351> eVar) {
            super(1, eVar);
            this.$roomId = str;
            this.$replyMsg = str2;
            this.$sticker = sticker;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12351(this.$roomId, this.$replyMsg, this.$sticker, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12351) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = ChatViewModel.this.mainRepository;
                String str = this.$roomId;
                String str2 = this.$replyMsg;
                Sticker sticker = this.$sticker;
                this.label = 1;
                if (mainRepository.sendSticker(str, str2, sticker, this) == objG) {
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
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$sendVideos$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$sendVideos$1", f = "ChatViewModel.kt", l = {360}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12361 extends cb.m implements Function1 {
        final /* synthetic */ String $content;
        final /* synthetic */ List<File> $files;
        final /* synthetic */ String $replyMsg;
        final /* synthetic */ String $roomId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C12361(String str, List<? extends File> list, String str2, String str3, ab.e<? super C12361> eVar) {
            super(1, eVar);
            this.$roomId = str;
            this.$files = list;
            this.$content = str2;
            this.$replyMsg = str3;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12361(this.$roomId, this.$files, this.$content, this.$replyMsg, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12361) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = ChatViewModel.this.mainRepository;
                String str = this.$roomId;
                List<File> list = this.$files;
                String str2 = this.$content;
                String str3 = this.$replyMsg;
                this.label = 1;
                if (mainRepository.sendVideos(str, list, str2, str3, this) == objG) {
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
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$setChatBackground$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$setChatBackground$1", f = "ChatViewModel.kt", l = {920, 921, 922}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12371 extends cb.m implements Function1 {
        final /* synthetic */ String $path;
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12371(String str, String str2, ab.e<? super C12371> eVar) {
            super(1, eVar);
            this.$uid = str;
            this.$path = str2;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12371(this.$uid, this.$path, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12371) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
        
            if (r6.setRoomBackground(r1, r3, r5) == r0) goto L20;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r5.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L25
                if (r1 == r4) goto L21
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                ua.v.b(r6)
                goto L59
            L15:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1d:
                ua.v.b(r6)
                goto L46
            L21:
                ua.v.b(r6)
                goto L3b
            L25:
                ua.v.b(r6)
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r6 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.this
                cu.todus.android.repositories.RoomsRepository r6 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getRoomsRepository$p(r6)
                java.lang.String r1 = r5.$uid
                r5.label = r4
                java.lang.String r4 = ""
                java.lang.Object r6 = r6.setRoomBackground(r4, r1, r5)
                if (r6 != r0) goto L3b
                goto L58
            L3b:
                r5.label = r3
                r3 = 100
                java.lang.Object r6 = pe.w0.b(r3, r5)
                if (r6 != r0) goto L46
                goto L58
            L46:
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r6 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.this
                cu.todus.android.repositories.RoomsRepository r6 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getRoomsRepository$p(r6)
                java.lang.String r1 = r5.$path
                java.lang.String r3 = r5.$uid
                r5.label = r2
                java.lang.Object r6 = r6.setRoomBackground(r1, r3, r5)
                if (r6 != r0) goto L59
            L58:
                return r0
            L59:
                ua.k0 r6 = ua.k0.f43947a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.C12371.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$setRoomDraft$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$setRoomDraft$1", f = "ChatViewModel.kt", l = {TypedValues.PositionType.TYPE_PERCENT_WIDTH}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12381 extends cb.m implements Function1 {
        final /* synthetic */ String $input;
        final /* synthetic */ String $roomId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12381(String str, String str2, ab.e<? super C12381> eVar) {
            super(1, eVar);
            this.$input = str;
            this.$roomId = str2;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12381(this.$input, this.$roomId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12381) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                RoomsRepository roomsRepository = ChatViewModel.this.roomsRepository;
                String str = this.$input;
                String str2 = this.$roomId;
                this.label = 1;
                if (roomsRepository.updateDraftState(str, str2, this) == objG) {
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
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$setUnknownRoomAsAccepted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$setUnknownRoomAsAccepted$1", f = "ChatViewModel.kt", l = {936}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12391 extends cb.m implements Function1 {
        final /* synthetic */ String $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12391(String str, ab.e<? super C12391> eVar) {
            super(1, eVar);
            this.$id = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12391(this.$id, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12391) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                RoomsRepository roomsRepository = ChatViewModel.this.roomsRepository;
                String str = this.$id;
                this.label = 1;
                if (roomsRepository.setUnknownState(str, Room.UR_ACCEPTED, this) == objG) {
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
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$setUnknownRoomAsRejected$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$setUnknownRoomAsRejected$2", f = "ChatViewModel.kt", l = {942, 946, 949, 956}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12402 extends cb.m implements Function1 {
        final /* synthetic */ String $id;
        final /* synthetic */ lb.a $onComplete;
        int I$0;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$setUnknownRoomAsRejected$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$setUnknownRoomAsRejected$2$1", f = "ChatViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class AnonymousClass1 extends cb.m implements Function2 {
            final /* synthetic */ lb.a $onComplete;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(lb.a aVar, ab.e<? super AnonymousClass1> eVar) {
                super(2, eVar);
                this.$onComplete = aVar;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new AnonymousClass1(this.$onComplete, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onComplete.invoke();
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((AnonymousClass1) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12402(String str, lb.a aVar, ab.e<? super C12402> eVar) {
            super(1, eVar);
            this.$id = str;
            this.$onComplete = aVar;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12402(this.$id, this.$onComplete, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12402) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code duplicated, block: B:32:0x009f  */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
        
            if (r10 == r0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x007b, code lost:
        
            if (r10 == r0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00af, code lost:
        
            if (r1.clearAndDeleteRoom(r3, r9) == r0) goto L34;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v16, types: [int] */
        /* JADX WARN: Type inference failed for: r10v23 */
        /* JADX WARN: Type inference failed for: r10v24 */
        /* JADX WARN: Type inference failed for: r10v6 */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r9.label
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2d
                if (r1 == r5) goto L29
                if (r1 == r4) goto L25
                if (r1 == r3) goto L21
                if (r1 != r2) goto L19
                ua.v.b(r10)
                goto Lb2
            L19:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L21:
                ua.v.b(r10)
                goto L7e
            L25:
                ua.v.b(r10)
                goto L5e
            L29:
                ua.v.b(r10)
                goto L43
            L2d:
                ua.v.b(r10)
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r10 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.this
                cu.todus.android.repositories.RoomsRepository r10 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getRoomsRepository$p(r10)
                java.lang.String r1 = r9.$id
                r9.label = r5
                java.lang.String r5 = "rejected"
                java.lang.Object r10 = r10.setUnknownState(r1, r5, r9)
                if (r10 != r0) goto L43
                goto Lb1
            L43:
                cu.todus.android.xmpp.XMPPUtils r10 = cu.todus.android.xmpp.XMPPUtils.INSTANCE
                java.lang.String r1 = r9.$id
                boolean r1 = r10.isChannel(r1)
                if (r1 == 0) goto L65
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r10 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.this
                cu.todus.android.repositories.MainRepository r10 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getMainRepository$p(r10)
                java.lang.String r1 = r9.$id
                r9.label = r4
                java.lang.Object r10 = r10.leaveChannel(r1, r9)
                if (r10 != r0) goto L5e
                goto Lb1
            L5e:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                goto L86
            L65:
                java.lang.String r1 = r9.$id
                boolean r10 = r10.isMUC(r1)
                if (r10 == 0) goto L85
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r10 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.this
                cu.todus.android.repositories.MainRepository r10 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getMainRepository$p(r10)
                java.lang.String r1 = r9.$id
                r9.label = r3
                java.lang.Object r10 = r10.leaveGroup(r1, r9)
                if (r10 != r0) goto L7e
                goto Lb1
            L7e:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                goto L86
            L85:
                r10 = 0
            L86:
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r1 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.this
                pe.m0 r3 = androidx.p001lifecycle.ViewModelKt.getViewModelScope(r1)
                pe.k2 r4 = pe.d1.c()
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$setUnknownRoomAsRejected$2$1 r6 = new cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$setUnknownRoomAsRejected$2$1
                lb.a r1 = r9.$onComplete
                r5 = 0
                r6.<init>(r1, r5)
                r7 = 2
                r8 = 0
                pe.i.d(r3, r4, r5, r6, r7, r8)
                if (r10 == 0) goto Lb2
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r1 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.this
                cu.todus.android.repositories.RoomsRepository r1 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getRoomsRepository$p(r1)
                java.lang.String r3 = r9.$id
                r9.I$0 = r10
                r9.label = r2
                java.lang.Object r10 = r1.clearAndDeleteRoom(r3, r9)
                if (r10 != r0) goto Lb2
            Lb1:
                return r0
            Lb2:
                ua.k0 r10 = ua.k0.f43947a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.C12402.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$setUnknownUserAsBlocked$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$setUnknownUserAsBlocked$1", f = "ChatViewModel.kt", l = {962, 964}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12411 extends cb.m implements Function1 {
        final /* synthetic */ String $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12411(String str, ab.e<? super C12411> eVar) {
            super(1, eVar);
            this.$id = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12411(this.$id, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12411) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
        
            if (r5.changeBlockState(r1, r4) == r0) goto L15;
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
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                ua.v.b(r5)
                goto L45
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                ua.v.b(r5)
                goto L34
            L1e:
                ua.v.b(r5)
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r5 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.this
                cu.todus.android.repositories.RoomsRepository r5 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getRoomsRepository$p(r5)
                java.lang.String r1 = r4.$id
                r4.label = r3
                java.lang.String r3 = "blocked"
                java.lang.Object r5 = r5.setUnknownState(r1, r3, r4)
                if (r5 != r0) goto L34
                goto L44
            L34:
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r5 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.this
                cu.todus.android.repositories.MainRepository r5 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getMainRepository$p(r5)
                java.lang.String r1 = r4.$id
                r4.label = r2
                java.lang.Object r5 = r5.changeBlockState(r1, r4)
                if (r5 != r0) goto L45
            L44:
                return r0
            L45:
                ua.k0 r5 = ua.k0.f43947a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.C12411.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$setUnknownUserAsShared$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$setUnknownUserAsShared$1", f = "ChatViewModel.kt", l = {970}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12421 extends cb.m implements Function1 {
        final /* synthetic */ String $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12421(String str, ab.e<? super C12421> eVar) {
            super(1, eVar);
            this.$id = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12421(this.$id, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12421) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                RoomsRepository roomsRepository = ChatViewModel.this.roomsRepository;
                String str = this.$id;
                this.label = 1;
                if (roomsRepository.setUnknownState(str, Room.UR_SHARED, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            ChatViewModel.sendContact$default(ChatViewModel.this, this.$id, new ContactContent(ChatViewModel.this.getOwner().getUsername(), ChatViewModel.this.getOwner().getAlias(), "", ChatViewModel.this.getOwner().getPhotoUrl()), null, 4, null);
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$share$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$share$1", f = "ChatViewModel.kt", l = {683}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12431 extends cb.m implements Function1 {
        final /* synthetic */ List<String> $msgIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12431(List<String> list, ab.e<? super C12431> eVar) {
            super(1, eVar);
            this.$msgIds = list;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12431(this.$msgIds, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12431) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = ChatViewModel.this.mainRepository;
                List<String> list = this.$msgIds;
                this.label = 1;
                if (mainRepository.shareMsgs(list, this) == objG) {
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
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$startAudioCallNew$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$startAudioCallNew$1", f = "ChatViewModel.kt", l = {AnalyticsListener.EVENT_RENDERER_READY_CHANGED}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12441 extends cb.m implements Function1 {
        final /* synthetic */ lb.a $onStarted;
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12441(String str, lb.a aVar, ab.e<? super C12441> eVar) {
            super(1, eVar);
            this.$uid = str;
            this.$onStarted = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$0(ChatViewModel chatViewModel, lb.a aVar) {
            Thread.currentThread().getName();
            pe.k.d(ViewModelKt.getViewModelScope(chatViewModel), d1.c(), null, new ChatViewModel$startAudioCallNew$1$1$1(aVar, null), 2, null);
            return k0.f43947a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$1(ChatViewModel chatViewModel) {
            MainRepository mainRepository = chatViewModel.mainRepository;
            String string = UUID.randomUUID().toString();
            y.h(string, "toString(...)");
            String strO = a0.O(string, "-", "", false, 4, null);
            Cause cause = Cause.ERROR;
            String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.u_are_busy_cannot_call);
            y.h(string2, "getString(...)");
            mainRepository.addNewNotification(new InsideNotificationState(strO, cause, string2));
            return k0.f43947a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$2(ChatViewModel chatViewModel) {
            MainRepository mainRepository = chatViewModel.mainRepository;
            String string = UUID.randomUUID().toString();
            y.h(string, "toString(...)");
            String strO = a0.O(string, "-", "", false, 4, null);
            Cause cause = Cause.ERROR;
            String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
            y.h(string2, "getString(...)");
            mainRepository.addNewNotification(new InsideNotificationState(strO, cause, string2));
            return k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12441(this.$uid, this.$onStarted, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12441) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    v.b(obj);
                    MainRepository mainRepository = ChatViewModel.this.mainRepository;
                    String str = this.$uid;
                    final ChatViewModel chatViewModel = ChatViewModel.this;
                    final lb.a aVar = this.$onStarted;
                    lb.a aVar2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.g
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatViewModel.C12441.invokeSuspend$lambda$0(chatViewModel, aVar);
                        }
                    };
                    final ChatViewModel chatViewModel2 = ChatViewModel.this;
                    lb.a aVar3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.h
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatViewModel.C12441.invokeSuspend$lambda$1(chatViewModel2);
                        }
                    };
                    final ChatViewModel chatViewModel3 = ChatViewModel.this;
                    lb.a aVar4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.i
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatViewModel.C12441.invokeSuspend$lambda$2(chatViewModel3);
                        }
                    };
                    this.label = 1;
                    if (mainRepository.startCallProcessNew(str, false, aVar2, aVar3, aVar4, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.b(obj);
                }
            } catch (Exception e10) {
                Log.e("ChatViewModel", "Error en startAudioCallNew: " + e10.getMessage(), e10);
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$startCall$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$startCall$1", f = "ChatViewModel.kt", l = {1000}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12451 extends cb.m implements Function1 {
        final /* synthetic */ lb.a $onStarted;
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12451(String str, lb.a aVar, ab.e<? super C12451> eVar) {
            super(1, eVar);
            this.$uid = str;
            this.$onStarted = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$0(ChatViewModel chatViewModel, lb.a aVar) {
            pe.k.d(ViewModelKt.getViewModelScope(chatViewModel), d1.c(), null, new ChatViewModel$startCall$1$1$1(aVar, null), 2, null);
            return k0.f43947a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$1(ChatViewModel chatViewModel) {
            MainRepository mainRepository = chatViewModel.mainRepository;
            String string = UUID.randomUUID().toString();
            y.h(string, "toString(...)");
            String strO = a0.O(string, "-", "", false, 4, null);
            Cause cause = Cause.ERROR;
            String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.u_are_busy_cannot_call);
            y.h(string2, "getString(...)");
            mainRepository.addNewNotification(new InsideNotificationState(strO, cause, string2));
            return k0.f43947a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$2(ChatViewModel chatViewModel) {
            MainRepository mainRepository = chatViewModel.mainRepository;
            String string = UUID.randomUUID().toString();
            y.h(string, "toString(...)");
            String strO = a0.O(string, "-", "", false, 4, null);
            Cause cause = Cause.ERROR;
            String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
            y.h(string2, "getString(...)");
            mainRepository.addNewNotification(new InsideNotificationState(strO, cause, string2));
            return k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12451(this.$uid, this.$onStarted, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12451) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = ChatViewModel.this.mainRepository;
                String str = this.$uid;
                final ChatViewModel chatViewModel = ChatViewModel.this;
                final lb.a aVar = this.$onStarted;
                lb.a aVar2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.j
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatViewModel.C12451.invokeSuspend$lambda$0(chatViewModel, aVar);
                    }
                };
                final ChatViewModel chatViewModel2 = ChatViewModel.this;
                lb.a aVar3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.k
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatViewModel.C12451.invokeSuspend$lambda$1(chatViewModel2);
                    }
                };
                final ChatViewModel chatViewModel3 = ChatViewModel.this;
                lb.a aVar4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.l
                    @Override // lb.a
                    public final Object invoke() {
                        return ChatViewModel.C12451.invokeSuspend$lambda$2(chatViewModel3);
                    }
                };
                this.label = 1;
                if (MainRepository.startCallProcess$default(mainRepository, str, false, aVar2, aVar3, aVar4, this, 2, null) == objG) {
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
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$startVideoCallNew$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$startVideoCallNew$1", f = "ChatViewModel.kt", l = {1072}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12461 extends cb.m implements Function1 {
        final /* synthetic */ lb.a $onStarted;
        final /* synthetic */ String $uid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12461(String str, lb.a aVar, ab.e<? super C12461> eVar) {
            super(1, eVar);
            this.$uid = str;
            this.$onStarted = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$0(ChatViewModel chatViewModel, lb.a aVar) {
            Thread.currentThread().getName();
            pe.k.d(ViewModelKt.getViewModelScope(chatViewModel), d1.c(), null, new ChatViewModel$startVideoCallNew$1$1$1(aVar, null), 2, null);
            return k0.f43947a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$1(ChatViewModel chatViewModel) {
            MainRepository mainRepository = chatViewModel.mainRepository;
            String string = UUID.randomUUID().toString();
            y.h(string, "toString(...)");
            String strO = a0.O(string, "-", "", false, 4, null);
            Cause cause = Cause.ERROR;
            String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.u_are_busy_cannot_call);
            y.h(string2, "getString(...)");
            mainRepository.addNewNotification(new InsideNotificationState(strO, cause, string2));
            return k0.f43947a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final k0 invokeSuspend$lambda$2(ChatViewModel chatViewModel) {
            MainRepository mainRepository = chatViewModel.mainRepository;
            String string = UUID.randomUUID().toString();
            y.h(string, "toString(...)");
            String strO = a0.O(string, "-", "", false, 4, null);
            Cause cause = Cause.ERROR;
            String string2 = MainModule.INSTANCE.getInstance().getAppContext().getString(R.string.network_error);
            y.h(string2, "getString(...)");
            mainRepository.addNewNotification(new InsideNotificationState(strO, cause, string2));
            return k0.f43947a;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12461(this.$uid, this.$onStarted, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12461) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    v.b(obj);
                    MainRepository mainRepository = ChatViewModel.this.mainRepository;
                    String str = this.$uid;
                    final ChatViewModel chatViewModel = ChatViewModel.this;
                    final lb.a aVar = this.$onStarted;
                    lb.a aVar2 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.m
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatViewModel.C12461.invokeSuspend$lambda$0(chatViewModel, aVar);
                        }
                    };
                    final ChatViewModel chatViewModel2 = ChatViewModel.this;
                    lb.a aVar3 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.n
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatViewModel.C12461.invokeSuspend$lambda$1(chatViewModel2);
                        }
                    };
                    final ChatViewModel chatViewModel3 = ChatViewModel.this;
                    lb.a aVar4 = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.o
                        @Override // lb.a
                        public final Object invoke() {
                            return ChatViewModel.C12461.invokeSuspend$lambda$2(chatViewModel3);
                        }
                    };
                    this.label = 1;
                    if (mainRepository.startCallProcessNew(str, true, aVar2, aVar3, aVar4, this) == objG) {
                        return objG;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.b(obj);
                }
            } catch (Exception e10) {
                Log.e("ChatViewModel", "Error en startVideoCallNew: " + e10.getMessage(), e10);
            }
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$stopRecorderAndSend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$stopRecorderAndSend$1", f = "ChatViewModel.kt", l = {451, 454}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12471 extends cb.m implements Function1 {
        final /* synthetic */ String $roomId;
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12471(String str, ab.e<? super C12471> eVar) {
            super(1, eVar);
            this.$roomId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12471(this.$roomId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12471) create(eVar)).invokeSuspend(k0.f43947a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0087, code lost:
        
            if (cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.sendVoice$default(r4, r5, r6, r7, null, r12, 8, null) == r0) goto L26;
         */
        @Override // cb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = bb.b.g()
                int r1 = r12.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L32
                if (r1 == r3) goto L26
                if (r1 != r2) goto L1e
                java.lang.Object r0 = r12.L$1
                cu.todus.android.data.db.entity.toDus.Room r0 = (cu.todus.android.data.db.entity.toDus.Room) r0
                java.lang.Object r0 = r12.L$0
                java.io.File r0 = (java.io.File) r0
                ua.v.b(r13)     // Catch: java.lang.Exception -> L1b
                goto L8d
            L1b:
                r0 = move-exception
                r13 = r0
                goto L8a
            L1e:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L26:
                int r1 = r12.I$0
                java.lang.Object r4 = r12.L$0
                java.io.File r4 = (java.io.File) r4
                ua.v.b(r13)     // Catch: java.lang.Exception -> L1b
            L2f:
                r7 = r1
                r6 = r4
                goto L63
            L32:
                ua.v.b(r13)
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r13 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.this     // Catch: java.lang.Exception -> L1b
                te.p0 r13 = r13.getRecordingTime()     // Catch: java.lang.Exception -> L1b
                java.lang.Object r13 = r13.getValue()     // Catch: java.lang.Exception -> L1b
                java.lang.Number r13 = (java.lang.Number) r13     // Catch: java.lang.Exception -> L1b
                long r4 = r13.longValue()     // Catch: java.lang.Exception -> L1b
                int r13 = (int) r4     // Catch: java.lang.Exception -> L1b
                int r1 = r13 / 1000
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r13 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.this     // Catch: java.lang.Exception -> L1b
                java.io.File r4 = r13.stopRecorder()     // Catch: java.lang.Exception -> L1b
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r13 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.this     // Catch: java.lang.Exception -> L1b
                cu.todus.android.repositories.MainRepository r13 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.access$getMainRepository$p(r13)     // Catch: java.lang.Exception -> L1b
                java.lang.String r5 = r12.$roomId     // Catch: java.lang.Exception -> L1b
                r12.L$0 = r4     // Catch: java.lang.Exception -> L1b
                r12.I$0 = r1     // Catch: java.lang.Exception -> L1b
                r12.label = r3     // Catch: java.lang.Exception -> L1b
                java.lang.Object r13 = r13.getRoomById(r5, r12)     // Catch: java.lang.Exception -> L1b
                if (r13 != r0) goto L2f
                goto L89
            L63:
                r5 = r13
                cu.todus.android.data.db.entity.toDus.Room r5 = (cu.todus.android.data.db.entity.toDus.Room) r5     // Catch: java.lang.Exception -> L1b
                if (r6 == 0) goto L8d
                if (r5 == 0) goto L8d
                if (r7 <= r3) goto L8d
                cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel r4 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.this     // Catch: java.lang.Exception -> L1b
                java.lang.Object r13 = cb.l.a(r6)     // Catch: java.lang.Exception -> L1b
                r12.L$0 = r13     // Catch: java.lang.Exception -> L1b
                java.lang.Object r13 = cb.l.a(r5)     // Catch: java.lang.Exception -> L1b
                r12.L$1 = r13     // Catch: java.lang.Exception -> L1b
                r12.I$0 = r7     // Catch: java.lang.Exception -> L1b
                r12.label = r2     // Catch: java.lang.Exception -> L1b
                r8 = 0
                r10 = 8
                r11 = 0
                r9 = r12
                java.lang.Object r13 = cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.sendVoice$default(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L1b
                if (r13 != r0) goto L8d
            L89:
                return r0
            L8a:
                r13.printStackTrace()
            L8d:
                ua.k0 r13 = ua.k0.f43947a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel.C12471.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$subscribe$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$subscribe$1", f = "ChatViewModel.kt", l = {785}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12481 extends cb.m implements Function1 {
        final /* synthetic */ Function1 $onCompleted;
        final /* synthetic */ String $uid;
        int label;

        /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$subscribe$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
        @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$subscribe$1$1", f = "ChatViewModel.kt", l = {}, m = "invokeSuspend", v = 2)
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lpe/m0;", "Lua/k0;", "<anonymous>", "(Lpe/m0;)V"}, k = 3, mv = {2, 3, 0})
        public static final class C02241 extends cb.m implements Function2 {
            final /* synthetic */ Function1 $onCompleted;
            final /* synthetic */ boolean $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02241(Function1 function1, boolean z10, ab.e<? super C02241> eVar) {
                super(2, eVar);
                this.$onCompleted = function1;
                this.$result = z10;
            }

            @Override // cb.a
            public final ab.e<k0> create(Object obj, ab.e<?> eVar) {
                return new C02241(this.$onCompleted, this.$result, eVar);
            }

            @Override // cb.a
            public final Object invokeSuspend(Object obj) {
                bb.b.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
                this.$onCompleted.invoke(cb.b.a(this.$result));
                return k0.f43947a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(m0 m0Var, ab.e<? super k0> eVar) {
                return ((C02241) create(m0Var, eVar)).invokeSuspend(k0.f43947a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12481(String str, Function1 function1, ab.e<? super C12481> eVar) {
            super(1, eVar);
            this.$uid = str;
            this.$onCompleted = function1;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12481(this.$uid, this.$onCompleted, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12481) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = ChatViewModel.this.mainRepository;
                String str = this.$uid;
                this.label = 1;
                obj = mainRepository.subscribeCard(str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v.b(obj);
            }
            pe.k.d(ViewModelKt.getViewModelScope(ChatViewModel.this), d1.c(), null, new C02241(this.$onCompleted, ((Boolean) obj).booleanValue(), null), 2, null);
            return k0.f43947a;
        }
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$tryResend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$tryResend$1", f = "ChatViewModel.kt", l = {264}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12491 extends cb.m implements Function1 {
        final /* synthetic */ String $msgId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12491(String str, ab.e<? super C12491> eVar) {
            super(1, eVar);
            this.$msgId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12491(this.$msgId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12491) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = ChatViewModel.this.mainRepository;
                String str = this.$msgId;
                this.label = 1;
                if (mainRepository.tryResendMsg(str, this) == objG) {
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
    }

    /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$unPinMsgInGroup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$unPinMsgInGroup$1", f = "ChatViewModel.kt", l = {535}, m = "invokeSuspend", v = 2)
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lua/k0;", "<anonymous>", "()V"}, k = 3, mv = {2, 3, 0})
    public static final class C12501 extends cb.m implements Function1 {
        final /* synthetic */ String $roomId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12501(String str, ab.e<? super C12501> eVar) {
            super(1, eVar);
            this.$roomId = str;
        }

        @Override // cb.a
        public final ab.e<k0> create(ab.e<?> eVar) {
            return ChatViewModel.this.new C12501(this.$roomId, eVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(ab.e<? super k0> eVar) {
            return ((C12501) create(eVar)).invokeSuspend(k0.f43947a);
        }

        @Override // cb.a
        public final Object invokeSuspend(Object obj) {
            Object objG = bb.b.g();
            int i10 = this.label;
            if (i10 == 0) {
                v.b(obj);
                MainRepository mainRepository = ChatViewModel.this.mainRepository;
                String str = this.$roomId;
                this.label = 1;
                if (mainRepository.unPinMsgInGroup(str, this) == objG) {
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
    }

    /* JADX WARN: Type inference failed for: r2v27, types: [cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$timer$1] */
    public ChatViewModel() throws SinglediException {
        MediaModule singletonInitializer = MediaModule.INSTANCE.getInstance();
        this.mediaModule = singletonInitializer;
        this.preferencesModule = PreferencesModule.INSTANCE.getInstance();
        this.notificationManager = NotificationManager.INSTANCE.getInstance();
        MainRepository singletonInitializer2 = MainRepository.INSTANCE.getInstance();
        this.mainRepository = singletonInitializer2;
        this.roomsRepository = RoomsRepository.INSTANCE.getInstance();
        this.stickersRepository = StickersRepository.INSTANCE.getInstance();
        this.usersRepository = UsersRepository.INSTANCE.getInstance();
        this.botShortcutRepository = BotShortcutRepository.INSTANCE.getInstance();
        this.statusRepository = StatusRepository.INSTANCE.getInstance();
        this.appVolatileState = AppVolatileState.INSTANCE.getInstance();
        this.messagePagingConfig = new PagingConfig(20, 20, true, 40, Integer.MAX_VALUE, 0, 32, null);
        this.gson = MainModule.INSTANCE.getInstance().getGson();
        b0 b0VarA = r0.a(w.n());
        this._mentionList = b0VarA;
        this.mentionList = te.j.b(b0VarA);
        this.actualMentionsToSend = new ArrayList<>();
        this.canSendTyping = true;
        this.timer = new CountDownTimer() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$timer$1
            {
                super(5000L, 5000L);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                this.this$0.canSendTyping = true;
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
            }
        };
        this.recordingTime = singletonInitializer.getAudioRecorder().getElapsedTime();
        b0 b0VarA2 = r0.a(null);
        this._chatScreenState = b0VarA2;
        this.chatScreenState = te.j.b(b0VarA2);
        this.msgList = w.n();
        b0 b0VarA3 = r0.a(Boolean.FALSE);
        this._allMsgsAreMine = b0VarA3;
        this.allMsgsAreMine = b0VarA3;
        this.loadingLink = "";
        b0 b0VarA4 = r0.a(FlowsState.INSTANCE.notRequested());
        this._requestingFriend = b0VarA4;
        this.requestingFriend = te.j.b(b0VarA4);
        this.contactsPagingConfig = new PagingConfig(30, 30, true, 60, Integer.MAX_VALUE, 0, 32, null);
        this.refreshing = singletonInitializer2.getChannelsInLoad();
        PagingConfig pagingConfig = new PagingConfig(10, 10, true, 5, Integer.MAX_VALUE, 0, 32, null);
        this.stickerPagingConfig = pagingConfig;
        this.favoriteStickers = CachedPagingDataKt.cachedIn(new Pager(pagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.c
            @Override // lb.a
            public final Object invoke() {
                return ChatViewModel.favoriteStickers$lambda$0(this.f21975c);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
        this.recentStickers = CachedPagingDataKt.cachedIn(new Pager(pagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.d
            @Override // lb.a
            public final Object invoke() {
                return ChatViewModel.recentStickers$lambda$0(this.f23234c);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
        this.allStickers = CachedPagingDataKt.cachedIn(new Pager(pagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.e
            @Override // lb.a
            public final Object invoke() {
                return ChatViewModel.allStickers$lambda$0(this.f23235c);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource allStickers$lambda$0(ChatViewModel chatViewModel) {
        return chatViewModel.stickersRepository.getStickers();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource chatMsgs$lambda$0(ChatViewModel chatViewModel, String str) {
        return chatViewModel.mainRepository.getMsgsByRoomIdForPaging(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource favoriteStickers$lambda$0(ChatViewModel chatViewModel) {
        return chatViewModel.stickersRepository.getFavoriteStickers();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource friendsOnDbNoHeaders$lambda$0(ChatViewModel chatViewModel, String str) {
        return chatViewModel.usersRepository.getFriends(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<MentionName> getMentions(String msgContent) {
        ArrayList<MentionName> arrayList = new ArrayList<>();
        for (MentionItemModel mentionItemModel : this.actualMentionsToSend) {
            if (d0.a0(msgContent, mentionItemModel.getToDusId(), false, 2, null)) {
                arrayList.add(new MentionName(mentionItemModel.getId(), null, d0.o0(msgContent, mentionItemModel.getToDusId(), 0, false, 6, null), mentionItemModel.getToDusId().length(), mentionItemModel.getToDusId(), 2, null));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object loadMentionList(String str, ab.e<? super k0> eVar) {
        C12201 c12201;
        String toDusId;
        if (eVar instanceof C12201) {
            c12201 = (C12201) eVar;
            int i10 = c12201.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c12201.label = i10 - Integer.MIN_VALUE;
            } else {
                c12201 = new C12201(eVar);
            }
        } else {
            c12201 = new C12201(eVar);
        }
        Object groupMentionableMembers = c12201.result;
        Object objG = bb.b.g();
        int i11 = c12201.label;
        if (i11 == 0) {
            v.b(groupMentionableMembers);
            MainRepository mainRepository = this.mainRepository;
            c12201.L$0 = cb.l.a(str);
            c12201.label = 1;
            groupMentionableMembers = mainRepository.getGroupMentionableMembers(str, c12201);
            if (groupMentionableMembers == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v.b(groupMentionableMembers);
        }
        List<RoomMember> list = (List) groupMentionableMembers;
        b0 b0Var = this._mentionList;
        ArrayList arrayList = new ArrayList(x.y(list, 10));
        for (RoomMember roomMember : list) {
            String id2 = roomMember.getId();
            String name = roomMember.getName();
            User user = roomMember.getUser();
            if (user == null || (toDusId = user.getToDusId()) == null) {
                toDusId = "";
            }
            arrayList.add(new MentionItemModel(id2, name, toDusId, roomMember.getPicture()));
        }
        b0Var.setValue(arrayList);
        return k0.f43947a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagingSource recentStickers$lambda$0(ChatViewModel chatViewModel) {
        return chatViewModel.stickersRepository.getRecentStickers();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reloadChatData(String uid) {
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12251(uid, this, null), 3, null);
    }

    public static /* synthetic */ void sendAudios$default(ChatViewModel chatViewModel, String str, List list, String str2, String str3, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        chatViewModel.sendAudios(str, list, str2, str3);
    }

    public static /* synthetic */ void sendContact$default(ChatViewModel chatViewModel, String str, ContactContent contactContent, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        chatViewModel.sendContact(str, contactContent, str2);
    }

    public static /* synthetic */ void sendFiles$default(ChatViewModel chatViewModel, String str, List list, String str2, String str3, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        chatViewModel.sendFiles(str, list, str2, str3);
    }

    public static /* synthetic */ void sendImages$default(ChatViewModel chatViewModel, String str, List list, String str2, String str3, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        chatViewModel.sendImages(str, list, str2, str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendMessage$default(ChatViewModel chatViewModel, String str, String str2, boolean z10, List list, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        boolean z11 = z10;
        if ((i10 & 8) != 0) {
            list = w.n();
        }
        chatViewModel.sendMessage(str, str2, z11, list, (i10 & 16) != 0 ? null : str3, (i10 & 32) != 0 ? null : str4, (i10 & 64) != 0 ? null : str5);
    }

    public static /* synthetic */ void sendSticker$default(ChatViewModel chatViewModel, String str, Sticker sticker, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        chatViewModel.sendSticker(str, sticker, str2);
    }

    public static /* synthetic */ void sendTyping$default(ChatViewModel chatViewModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        chatViewModel.sendTyping(z10);
    }

    public static /* synthetic */ void sendVideos$default(ChatViewModel chatViewModel, String str, List list, String str2, String str3, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        chatViewModel.sendVideos(str, list, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object sendVoice(Room room, File file, int i10, String str, ab.e<? super k0> eVar) {
        clearRoomDraft(room.getId());
        Object objSendVoice = this.mainRepository.sendVoice(room.getId(), file, i10, str, eVar);
        return objSendVoice == bb.b.g() ? objSendVoice : k0.f43947a;
    }

    public static /* synthetic */ Object sendVoice$default(ChatViewModel chatViewModel, Room room, File file, int i10, String str, ab.e eVar, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str = null;
        }
        return chatViewModel.sendVoice(room, file, i10, str, eVar);
    }

    public static /* synthetic */ void setUnknownRoomAsRejected$default(ChatViewModel chatViewModel, String str, lb.a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.f
                @Override // lb.a
                public final Object invoke() {
                    return k0.f43947a;
                }
            };
        }
        chatViewModel.setUnknownRoomAsRejected(str, aVar);
    }

    public final void allMsgsAreMine(List<String> list) {
        y.i(list, "list");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(list, null), 3, null);
    }

    public final te.h chatMsgs(final String uid) {
        y.i(uid, "uid");
        final te.h hVarF = te.j.f(new Pager(this.messagePagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.b
            @Override // lb.a
            public final Object invoke() {
                return ChatViewModel.chatMsgs$lambda$0(this.f21973c, uid);
            }
        }, 2, null).getFlow());
        return CachedPagingDataKt.cachedIn(new te.h() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$chatMsgs$$inlined$map$1

            /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$chatMsgs$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements te.i {
                final /* synthetic */ te.i $this_unsafeFlow;
                final /* synthetic */ ChatViewModel this$0;

                /* JADX INFO: renamed from: cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$chatMsgs$$inlined$map$1$2$1, reason: invalid class name */
                @cb.f(c = "cu.todus.android.uiCompose.main.screen.chat.component.ChatViewModel$chatMsgs$$inlined$map$1$2", f = "ChatViewModel.kt", l = {50}, m = "emit", v = 2)
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

                public AnonymousClass2(te.i iVar, ChatViewModel chatViewModel) {
                    this.$this_unsafeFlow = iVar;
                    this.this$0 = chatViewModel;
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
                        v.b(obj2);
                        te.i iVar = this.$this_unsafeFlow;
                        PagingData map = PagingDataTransforms__PagingDataTransformsKt.map((PagingData) obj, new ChatViewModel$chatMsgs$2$1(this.this$0, null));
                        anonymousClass1.L$0 = cb.l.a(obj);
                        anonymousClass1.L$1 = cb.l.a(anonymousClass1);
                        anonymousClass1.L$2 = cb.l.a(obj);
                        anonymousClass1.L$3 = cb.l.a(iVar);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (iVar.emit(map, anonymousClass1) == objG) {
                            return objG;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v.b(obj2);
                    }
                    return k0.f43947a;
                }
            }

            @Override // te.h
            public Object collect(te.i iVar, ab.e eVar) {
                Object objCollect = hVarF.collect(new AnonymousClass2(iVar, this), eVar);
                return objCollect == bb.b.g() ? objCollect : k0.f43947a;
            }
        }, ViewModelKt.getViewModelScope(this));
    }

    public final void clearRoomDraft(String roomId) {
        y.i(roomId, "roomId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12081(roomId, null), 3, null);
    }

    public final void deleteForAll(String uid, List<String> list) {
        y.i(uid, "uid");
        y.i(list, "list");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12091(uid, this, list, null), 3, null);
    }

    public final void deleteMessages(List<String> list) {
        y.i(list, "list");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12101(list, null), 3, null);
    }

    public final void displayAllMsg(String roomId) {
        y.i(roomId, "roomId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12111(roomId, null), 3, null);
    }

    public final void displaySingleMsgRead(Message msg) {
        y.i(msg, "msg");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12121(msg, this, null), 3, null);
    }

    public final te.h friendsOnDbNoHeaders(final String filter) {
        y.i(filter, "filter");
        return CachedPagingDataKt.cachedIn(new Pager(this.contactsPagingConfig, null, new lb.a() { // from class: cu.todus.android.uiCompose.main.screen.chat.component.a
            @Override // lb.a
            public final Object invoke() {
                return ChatViewModel.friendsOnDbNoHeaders$lambda$0(this.f21971c, filter);
            }
        }, 2, null).getFlow(), ViewModelKt.getViewModelScope(this));
    }

    public final ArrayList<MentionItemModel> getActualMentionsToSend() {
        return this.actualMentionsToSend;
    }

    public final p0 getAllMsgsAreMine() {
        return this.allMsgsAreMine;
    }

    public final te.h getAllStickers() {
        return this.allStickers;
    }

    public final List<BotShortcut> getAttachmentShortcuts() {
        return this.botShortcutRepository.getAttachmentShortcuts();
    }

    public final p0 getChatScreenState() {
        return this.chatScreenState;
    }

    public final te.h getFavoriteStickers() {
        return this.favoriteStickers;
    }

    public final v5.f getGson() {
        return this.gson;
    }

    public final p0 getMentionList() {
        return this.mentionList;
    }

    public final List<MessageWithPartnerWithReactions> getMsgList() {
        return this.msgList;
    }

    public final NotificationManager getNotificationManager() {
        return this.notificationManager;
    }

    public final Owner getOwner() {
        return (Owner) this.mainRepository.getOwner().invoke();
    }

    public final te.h getRecentStickers() {
        return this.recentStickers;
    }

    public final p0 getRecordingTime() {
        return this.recordingTime;
    }

    public final Z17MutableListFlow<String> getRefreshing() {
        return this.refreshing;
    }

    public final p0 getRequestingFriend() {
        return this.requestingFriend;
    }

    public final void getStatusPosition(String statusId, Function1 onFound) {
        y.i(statusId, "statusId");
        y.i(onFound, "onFound");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12131(statusId, onFound, null), 3, null);
    }

    public final void goChatByMention(MentionName mentionName, Function1 onLoaded, lb.a onError) {
        y.i(mentionName, "mentionName");
        y.i(onLoaded, "onLoaded");
        y.i(onError, "onError");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12141(mentionName, this, onError, onLoaded, null), 3, null);
    }

    public final void leaveAndDeleteCard(String uid, Function1 onComplete) {
        y.i(uid, "uid");
        y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12151(uid, onComplete, null), 3, null);
    }

    public final void loadChannelOldMsgs(String uid) {
        y.i(uid, "uid");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12161(uid, null), 3, null);
    }

    public final void loadChatMsgsFlow(String uid) {
        y.i(uid, "uid");
        pe.k.d(ViewModelKt.getViewModelScope(this), null, null, new C12171(uid, null), 3, null);
    }

    public final void loadChatState(String id2) {
        y.i(id2, "id");
        pe.k.d(ViewModelKt.getViewModelScope(this), null, null, new C12181(id2, null), 3, null);
        pe.k.d(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(id2, null), 3, null);
    }

    public final void loadLinkInfo(MessageWithPartnerWithReactions messageItemView) {
        y.i(messageItemView, "messageItemView");
        if (this.appVolatileState.getOwnerConnection() != Quality.BAD_QUALITY) {
            pe.k.d(ViewModelKt.getViewModelScope(this), null, null, new C12191(messageItemView, this, null), 3, null);
        }
    }

    public final void onChangeStickerFavoriteStatus(String id2, boolean value) {
        y.i(id2, "id");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12211(id2, value, null), 3, null);
    }

    public final void onReacted(String roomId, String msgId, String value) {
        y.i(roomId, "roomId");
        y.i(msgId, "msgId");
        y.i(value, "value");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12221(value, this, roomId, msgId, null), 3, null);
    }

    public final void pastToClipboard(List<String> msgIds, Context context) {
        y.i(msgIds, "msgIds");
        y.i(context, "context");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12231(msgIds, context, null), 3, null);
    }

    public final void pinMsgInGroup(String msgId, String roomId) {
        y.i(msgId, "msgId");
        y.i(roomId, "roomId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12241(msgId, roomId, null), 3, null);
    }

    public final void readRequestingFriend() {
        this._requestingFriend.setValue(FlowsState.INSTANCE.notRequested());
    }

    public final void reloadSelectedMsgsOnChannel(List<String> pubIds, String chId) {
        y.i(pubIds, "pubIds");
        y.i(chId, "chId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12261(pubIds, chId, null), 3, null);
    }

    public final void removeChatBackground(String uid) {
        y.i(uid, "uid");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12271(uid, null), 3, null);
    }

    public final void requestLast(String uid) {
        y.i(uid, "uid");
        pe.k.d(ViewModelKt.getViewModelScope(this), null, null, new C12281(uid, null), 3, null);
    }

    public final void requestUserByContact(String number, String name, String whoSendIt) {
        y.i(number, "number");
        y.i(name, "name");
        y.i(whoSendIt, "whoSendIt");
        this._requestingFriend.setValue(FlowsState.INSTANCE.loading());
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12291(number, name, null), 3, null);
    }

    public final void sendAudios(String roomId, List<? extends File> files, String content, String replyMsg) {
        y.i(roomId, "roomId");
        y.i(files, "files");
        y.i(content, "content");
        clearRoomDraft(roomId);
        if (!files.isEmpty() || content.length() > 0) {
            CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12301(roomId, files, content, replyMsg, null), 3, null);
        }
    }

    public final void sendContact(String roomId, ContactContent contactContent, String replyMsg) {
        y.i(roomId, "roomId");
        y.i(contactContent, "contactContent");
        clearRoomDraft(roomId);
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12311(roomId, contactContent, replyMsg, null), 3, null);
    }

    public final void sendFiles(String roomId, List<? extends File> files, String content, String replyMsg) {
        y.i(roomId, "roomId");
        y.i(files, "files");
        y.i(content, "content");
        clearRoomDraft(roomId);
        if (!files.isEmpty() || content.length() > 0) {
            CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12321(roomId, files, content, replyMsg, null), 3, null);
        }
    }

    public final void sendImages(String roomId, List<? extends File> files, String content, String replyMsg) {
        y.i(roomId, "roomId");
        y.i(files, "files");
        y.i(content, "content");
        clearRoomDraft(roomId);
        if (files.isEmpty() && d0.q0(content)) {
            return;
        }
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12331(roomId, files, content, replyMsg, null), 3, null);
    }

    public final void sendMessage(String text, String roomId, boolean removeForAll, List<String> messageList, String replyMsg, String msgIdForEdit, String msgPubIdForEdit) {
        y.i(text, "text");
        y.i(roomId, "roomId");
        y.i(messageList, "messageList");
        String string = d0.q1(text).toString();
        if (string.length() == 0) {
            return;
        }
        clearRoomDraft(roomId);
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12341(roomId, this, string, replyMsg, msgIdForEdit, removeForAll, messageList, msgPubIdForEdit, null), 3, null);
    }

    public final void sendSticker(String roomId, Sticker sticker, String replyMsg) {
        y.i(roomId, "roomId");
        y.i(sticker, "sticker");
        clearRoomDraft(roomId);
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12351(roomId, replyMsg, sticker, null), 3, null);
    }

    public final void sendTyping(boolean b10) {
        System.out.println((Object) "ENVIANDOOOOOOOOOOOOOOOOOOO info escribiendo....");
        if (this.chatScreenState.getValue() == null || !this.canSendTyping) {
            return;
        }
        this.canSendTyping = false;
        start();
        MainRepository mainRepository = this.mainRepository;
        Object value = this.chatScreenState.getValue();
        y.f(value);
        mainRepository.sendTyping(((ChatScreenState) value).getId(), b10);
    }

    public final void sendVideos(String roomId, List<? extends File> files, String content, String replyMsg) {
        y.i(roomId, "roomId");
        y.i(files, "files");
        y.i(content, "content");
        clearRoomDraft(roomId);
        if (!files.isEmpty() || content.length() > 0) {
            CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12361(roomId, files, content, replyMsg, null), 3, null);
        }
    }

    public final void setChatBackground(String path, String uid) {
        y.i(path, "path");
        y.i(uid, "uid");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12371(uid, path, null), 3, null);
    }

    public final void setMsgList(List<MessageWithPartnerWithReactions> list) {
        y.i(list, "<set-?>");
        this.msgList = list;
    }

    public final void setRoomDraft(String input, String roomId) {
        y.i(input, "input");
        y.i(roomId, "roomId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12381(input, roomId, null), 3, null);
    }

    public final void setUnknownRoomAsAccepted(String id2) {
        y.i(id2, "id");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12391(id2, null), 3, null);
    }

    public final void setUnknownRoomAsRejected(String id2, lb.a onComplete) {
        y.i(id2, "id");
        y.i(onComplete, "onComplete");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12402(id2, onComplete, null), 3, null);
    }

    public final void setUnknownUserAsBlocked(String id2) {
        y.i(id2, "id");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12411(id2, null), 3, null);
    }

    public final void setUnknownUserAsShared(String id2) {
        y.i(id2, "id");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12421(id2, null), 3, null);
    }

    public final void share(List<String> msgIds) {
        y.i(msgIds, "msgIds");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12431(msgIds, null), 3, null);
    }

    public final void startAudioCallNew(String uid, lb.a onStarted) {
        y.i(uid, "uid");
        y.i(onStarted, "onStarted");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12441(uid, onStarted, null), 3, null);
    }

    public final void startCall(String uid, lb.a onStarted) {
        y.i(uid, "uid");
        y.i(onStarted, "onStarted");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12451(uid, onStarted, null), 3, null);
    }

    public final void startPlaying(MediaPlayerData mpd, Context context) throws IOException {
        y.i(mpd, "mpd");
        y.i(context, "context");
        this.mediaModule.startPlaying(mpd, context);
    }

    public final File startRecorder(String id2) {
        y.i(id2, "id");
        return MediaModule.INSTANCE.getInstance().startRecorder(id2);
    }

    public final void startVideoCallNew(String uid, lb.a onStarted) {
        y.i(uid, "uid");
        y.i(onStarted, "onStarted");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12461(uid, onStarted, null), 3, null);
    }

    public final void stopPlaying() {
        this.mediaModule.stopPlaying();
    }

    public final File stopRecorder() {
        return MediaModule.INSTANCE.getInstance().stopRecorder();
    }

    public final void stopRecorderAndSend(String roomId) {
        y.i(roomId, "roomId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12471(roomId, null), 3, null);
    }

    public final void subscribe(String uid, Function1 onCompleted) {
        y.i(uid, "uid");
        y.i(onCompleted, "onCompleted");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12481(uid, onCompleted, null), 3, null);
    }

    public final void tryResend(String msgId) {
        y.i(msgId, "msgId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12491(msgId, null), 3, null);
    }

    public final void unPinMsgInGroup(String roomId) {
        y.i(roomId, "roomId");
        CoroutineUtilsKt.launchWithContext$default(ViewModelKt.getViewModelScope(this), null, null, new C12501(roomId, null), 3, null);
    }
}
