package cu.todus.android.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.Spannable;
import android.util.Log;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.Person;
import androidx.core.app.RemoteInput;
import androidx.core.app.TaskStackBuilder;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.media3.common.C;
import androidx.media3.common.util.j;
import androidx.media3.common.util.k;
import cu.todus.android.R;
import cu.todus.android.constants.CloudType;
import cu.todus.android.data.db.entity.configs.Config;
import cu.todus.android.data.db.entity.configs.Heritage;
import cu.todus.android.data.db.entity.configs.Values;
import cu.todus.android.data.db.entity.toDus.Room;
import cu.todus.android.data.db.entity.toDus.UserRoomJoin;
import cu.todus.android.data.preferences.Owner;
import cu.todus.android.data.util.MediaUtil;
import cu.todus.android.domain.Domain;
import cu.todus.android.notification.notifications.CallNotification;
import cu.todus.android.notification.notifications.FirebaseNotification;
import cu.todus.android.notification.notifications.INotification;
import cu.todus.android.notification.notifications.MessageNotification;
import cu.todus.android.notification.notifications.UnreadMessageNotification;
import cu.todus.android.notification.service.DirectReplyIntent;
import cu.todus.android.uiCompose.main.MainActivity;
import cu.todus.android.uiCompose.main.screen.chat.component.ChatParams;
import cu.todus.android.utils.NumberInlineFunctionsKt;
import cu.todus.android.utils.TextUtilsKt;
import cu.todus.android.webrtc.notification.IncomingCallNotificationBuilder;
import cu.todus.android.xmpp.XMPPUtils;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import pb.d;
import va.g0;
import va.w;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ1\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J5\u0010\u001e\u001a\u00020\u00102$\u0010\u001d\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u001a0\u0018H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b \u0010!J5\u0010(\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u000e¢\u0006\u0004\b(\u0010)J\u0015\u0010*\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\n¢\u0006\u0004\b*\u0010+J=\u0010-\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u000e¢\u0006\u0004\b-\u0010.J\u0015\u0010/\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\n¢\u0006\u0004\b/\u0010+R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00100R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00066"}, d2 = {"Lcu/todus/android/notification/SystemNotificationExecutor;", "Lcu/todus/android/notification/ExecutorNotification;", "Lcu/todus/android/data/preferences/Owner;", UserRoomJoin.AFFILIATION_OWNER, "Landroid/content/Context;", "context", "Landroidx/core/app/NotificationManagerCompat;", "notificationManager", "<init>", "(Lcu/todus/android/data/preferences/Owner;Landroid/content/Context;Landroidx/core/app/NotificationManagerCompat;)V", "", "channelId", "name", "description", "", "sound", "Lua/k0;", "createNotificationChannel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Lcu/todus/android/data/db/entity/configs/Heritage;", Config.TABLE_NAME, "", "getNotificationId", "(Lcu/todus/android/data/db/entity/configs/Heritage;)I", "Lkotlin/Pair;", "Lcu/todus/android/data/db/entity/configs/Values;", "", "", "Lcu/todus/android/notification/notifications/INotification;", CloudType.WORKER_NOTIFICATION, "notify", "(Lkotlin/Pair;)V", "cancel", "(Lcu/todus/android/data/db/entity/configs/Heritage;)V", "attId", "fileName", "", "bytesUsed", "totalBytes", "isCompleted", "notifyShowDirectDownloadProgress", "(Ljava/lang/String;Ljava/lang/String;JJZ)V", "dismissDirectDownload", "(Ljava/lang/String;)V", Room.COLUMN_LAST_MSG, "notifyShowDirectUploadProgress", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJZ)V", "dismissDirectUpload", "Lcu/todus/android/data/preferences/Owner;", "Landroidx/core/app/NotificationManagerCompat;", "Lcu/todus/android/webrtc/notification/IncomingCallNotificationBuilder;", "incomingCallNotificationBuilder", "Lcu/todus/android/webrtc/notification/IncomingCallNotificationBuilder;", "Companion", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SystemNotificationExecutor extends ExecutorNotification {
    public static final String ACTION = "action";
    public static final String GROUP_KEY_MESSAGE_INCOMING = "cu.todus.android.MESSAGE_INCOMING";
    public static final String ID = "id";
    public static final String OPEN_CHAT = "open_chat_from_notification";
    public static final String ROOM_TYPE = "ROOM_TYPE";
    private final IncomingCallNotificationBuilder incomingCallNotificationBuilder;
    private final NotificationManagerCompat notificationManager;
    private final Owner owner;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcu/todus/android/notification/SystemNotificationExecutor$Companion;", "", "<init>", "()V", "ACTION", "", "OPEN_CHAT", "ID", SystemNotificationExecutor.ROOM_TYPE, "GROUP_KEY_MESSAGE_INCOMING", "retrieveFlags", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(p pVar) {
            this();
        }

        public final int retrieveFlags() {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 34) {
                return 50331648;
            }
            if (i10 >= 31) {
                return 167772160;
            }
            return C.BUFFER_FLAG_FIRST_SAMPLE;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SystemNotificationExecutor(Owner owner, Context context, NotificationManagerCompat notificationManager) {
        super(context);
        y.i(owner, "owner");
        y.i(context, "context");
        y.i(notificationManager, "notificationManager");
        this.owner = owner;
        this.notificationManager = notificationManager;
        IncomingCallNotificationBuilder incomingCallNotificationBuilder = new IncomingCallNotificationBuilder(context);
        this.incomingCallNotificationBuilder = incomingCallNotificationBuilder;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 24) {
            if (i10 >= 26) {
                incomingCallNotificationBuilder.createNotificationChannel();
            }
            String string = context.getResources().getString(R.string.private_chats);
            y.h(string, "getString(...)");
            String string2 = context.getResources().getString(R.string.notification_private_chats);
            y.h(string2, "getString(...)");
            createNotificationChannel$default(this, ConfigProcessor.NOTIFICATION_CHANNEL_PRIVATE_CHAT, string, string2, false, 8, null);
            String string3 = context.getResources().getString(R.string.groups);
            y.h(string3, "getString(...)");
            String string4 = context.getResources().getString(R.string.group_notifications);
            y.h(string4, "getString(...)");
            createNotificationChannel$default(this, ConfigProcessor.NOTIFICATION_CHANNEL_GROUP, string3, string4, false, 8, null);
            String string5 = context.getResources().getString(R.string.download_service);
            y.h(string5, "getString(...)");
            String string6 = context.getResources().getString(R.string.download_service);
            y.h(string6, "getString(...)");
            createNotificationChannel(ConfigProcessor.NOTIFICATION_CHANNEL_DOWNLOAD, string5, string6, false);
            String string7 = context.getResources().getString(R.string.upload_service);
            y.h(string7, "getString(...)");
            String string8 = context.getResources().getString(R.string.upload_service);
            y.h(string8, "getString(...)");
            createNotificationChannel(ConfigProcessor.NOTIFICATION_CHANNEL_UPLOAD, string7, string8, false);
            String string9 = context.getResources().getString(R.string.general_notifications);
            y.h(string9, "getString(...)");
            String string10 = context.getResources().getString(R.string.general_notifications);
            y.h(string10, "getString(...)");
            createNotificationChannel(ConfigProcessor.NOTIFICATION_CHANNEL_FIREBASE, string9, string10, false);
        }
    }

    private final void createNotificationChannel(String channelId, String name, String description, boolean sound) {
        if (Build.VERSION.SDK_INT >= 26) {
            k.a();
            NotificationChannel notificationChannelA = j.a(channelId, name, 4);
            notificationChannelA.setDescription(description);
            notificationChannelA.setBypassDnd(true);
            if (sound) {
                notificationChannelA.enableLights(true);
                notificationChannelA.setShowBadge(true);
                notificationChannelA.setLockscreenVisibility(1);
                notificationChannelA.setImportance(4);
                notificationChannelA.enableVibration(true);
                notificationChannelA.setVibrationPattern(new long[]{100, 200, 300});
            } else {
                notificationChannelA.setSound(null, new AudioAttributes.Builder().build());
                notificationChannelA.setLockscreenVisibility(-1);
                notificationChannelA.setImportance(2);
                notificationChannelA.enableLights(false);
                notificationChannelA.setShowBadge(false);
            }
            android.app.NotificationManager notificationManager = (android.app.NotificationManager) getContext().getSystemService(android.app.NotificationManager.class);
            y.f(notificationManager);
            notificationManager.createNotificationChannel(notificationChannelA);
        }
    }

    public static /* synthetic */ void createNotificationChannel$default(SystemNotificationExecutor systemNotificationExecutor, String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = true;
        }
        systemNotificationExecutor.createNotificationChannel(str, str2, str3, z10);
    }

    private final int getNotificationId(Heritage heritage) {
        String tag;
        Heritage heritage2 = heritage.getHeritage();
        String tag2 = heritage2 != null ? heritage2.getTag() : null;
        int iHashCode = tag2 != null ? tag2.hashCode() : 0;
        Heritage heritage3 = heritage.getHeritage();
        if (iHashCode < 0) {
            tag = heritage3 != null ? heritage3.getTag() : null;
            return (tag != null ? tag.hashCode() : 0) * (-1);
        }
        tag = heritage3 != null ? heritage3.getTag() : null;
        if (tag != null) {
            return tag.hashCode();
        }
        return 0;
    }

    @Override // cu.todus.android.notification.ExecutorNotification
    public void cancel(Heritage heritage) {
        y.i(heritage, "heritage");
        try {
            List<StatusBarNotification> activeNotifications = this.notificationManager.getActiveNotifications();
            y.h(activeNotifications, "getActiveNotifications(...)");
            for (StatusBarNotification statusBarNotification : activeNotifications) {
                if (statusBarNotification.getId() == getNotificationId(heritage)) {
                    this.notificationManager.cancel(null, statusBarNotification.getId());
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void dismissDirectDownload(String attId) {
        y.i(attId, "attId");
        try {
            this.notificationManager.cancel(getNotificationId(ConfigProcessor.INSTANCE.buildHeritageDownload(attId)));
        } catch (Exception e10) {
            Log.e("NOTIF_DOWNLOAD", "Error al borrar notificación: " + e10.getMessage());
        }
    }

    public final void dismissDirectUpload(String attId) {
        y.i(attId, "attId");
        try {
            this.notificationManager.cancel(getNotificationId(ConfigProcessor.INSTANCE.buildHeritageUpload(attId)));
        } catch (Exception e10) {
            Log.e("NOTIF_UPLOAD", "Error al borrar notificación: " + e10.getMessage());
        }
    }

    @Override // cu.todus.android.notification.ExecutorNotification
    public void notify(Pair<Values, ? extends Map.Entry<Heritage, ? extends Set<? extends INotification>>> notification) {
        String tag;
        int i10;
        NotificationCompat.MessagingStyle messagingStyle;
        INotification iNotification;
        int i11;
        String str;
        Class<MainActivity> cls;
        Person personBuild;
        y.i(notification, "notification");
        try {
            INotification iNotification2 = (INotification) g0.H0(notification.getSecond().getValue());
            int notificationId = getNotificationId(notification.getSecond().getKey());
            Class<MainActivity> cls2 = MainActivity.class;
            if (iNotification2 instanceof FirebaseNotification) {
                Intent intent = new Intent(getContext(), cls2);
                intent.addFlags(67108864);
                Context context = getContext();
                int i12 = Build.VERSION.SDK_INT;
                Notification notificationBuild = new NotificationCompat.Builder(getContext(), ConfigProcessor.NOTIFICATION_CHANNEL_FIREBASE).setSmallIcon(R.drawable.icon).setContentTitle(getContext().getString(R.string.app_name)).setContentText(getContext().getString(R.string.you_have_new_messages)).setAutoCancel(true).setPriority(-2).setContentIntent(PendingIntent.getActivity(context, 0, intent, i12 >= 31 ? 1107296256 : 1073741824)).build();
                y.h(notificationBuild, "build(...)");
                if (i12 < 33) {
                    this.notificationManager.notify(notificationId, notificationBuild);
                    return;
                } else {
                    if (ContextCompat.checkSelfPermission(getContext(), "android.permission.POST_NOTIFICATIONS") != 0) {
                        this.notificationManager.notify(notificationId, notificationBuild);
                        return;
                    }
                    return;
                }
            }
            if (iNotification2 instanceof CallNotification) {
                try {
                    this.notificationManager.notify(notificationId, this.incomingCallNotificationBuilder.buildNew(((CallNotification) iNotification2).getId(), ((CallNotification) iNotification2).getName(), ((CallNotification) iNotification2).getImage(), ((CallNotification) iNotification2).getIsVideoCall()));
                    return;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return;
                }
            }
            if (!notification.getFirst().getAlert() && (!(iNotification2 instanceof MessageNotification) || !((MessageNotification) iNotification2).getIsMention())) {
                return;
            }
            Heritage heritage = notification.getSecond().getKey().getHeritage();
            if (heritage == null || (tag = heritage.getTag()) == null) {
                tag = "";
            }
            String string = getContext().getResources().getString(R.string.reply);
            y.h(string, "getString(...)");
            String string2 = getContext().getResources().getString(R.string.mark_as_read);
            y.h(string2, "getString(...)");
            try {
                NotificationCompat.MessagingStyle messagingStyle2 = new NotificationCompat.MessagingStyle(new Person.Builder().setName(getContext().getString(R.string.f20195me)).build());
                if (XMPPUtils.INSTANCE.isMUC(tag)) {
                    messagingStyle2.setGroupConversation(true);
                    messagingStyle2.setConversationTitle(((INotification) g0.v0(notification.getSecond().getValue())).title());
                }
                Iterator it = g0.g0(notification.getSecond().getValue()).iterator();
                int count = 0;
                while (it.hasNext()) {
                    INotification iNotification3 = (INotification) it.next();
                    Iterator it2 = it;
                    if (iNotification3 instanceof MessageNotification) {
                        try {
                            ((MessageNotification) iNotification3).getSenderName();
                            ((MessageNotification) iNotification3).getMsgId();
                            ((MessageNotification) iNotification3).getRoomId();
                            ((MessageNotification) iNotification3).getBody();
                            Spannable messageEntities$default = Domain.parseMessageEntities$default(Domain.INSTANCE, TextUtilsKt.removeHtmlTags(((MessageNotification) iNotification3).getBody()), w.n(), false, getContext(), 4, null);
                            iNotification = iNotification2;
                            i11 = count;
                            try {
                                long jTimestamp = ((MessageNotification) iNotification3).timestamp();
                                if (((MessageNotification) iNotification3).getSenderName() != null) {
                                    cls = cls2;
                                    try {
                                        str = string2;
                                        try {
                                            Person.Builder name = new Person.Builder().setName(((MessageNotification) iNotification3).getSenderName());
                                            Bitmap senderPicture = ((MessageNotification) iNotification3).getSenderPicture();
                                            y.f(senderPicture);
                                            personBuild = name.setIcon(IconCompat.createWithAdaptiveBitmap(senderPicture)).build();
                                        } catch (Exception e11) {
                                            e = e11;
                                            e.printStackTrace();
                                        }
                                    } catch (Exception e12) {
                                        e = e12;
                                        str = string2;
                                    }
                                } else {
                                    str = string2;
                                    cls = cls2;
                                    personBuild = null;
                                }
                                y.f(messagingStyle2.addMessage(messageEntities$default, jTimestamp, personBuild));
                            } catch (Exception e13) {
                                e = e13;
                                str = string2;
                                cls = cls2;
                                e.printStackTrace();
                                count = i11;
                                it = it2;
                                cls2 = cls;
                                iNotification2 = iNotification;
                                string2 = str;
                            }
                        } catch (Exception e14) {
                            e = e14;
                            iNotification = iNotification2;
                            i11 = count;
                        }
                    } else {
                        iNotification = iNotification2;
                        i11 = count;
                        str = string2;
                        cls = cls2;
                        if (iNotification3 instanceof UnreadMessageNotification) {
                            count = i11 + ((UnreadMessageNotification) iNotification3).getCount();
                        }
                        it = it2;
                        cls2 = cls;
                        iNotification2 = iNotification;
                        string2 = str;
                    }
                    count = i11;
                    it = it2;
                    cls2 = cls;
                    iNotification2 = iNotification;
                    string2 = str;
                }
                INotification iNotification4 = iNotification2;
                int i13 = count;
                String str2 = string2;
                Class<MainActivity> cls3 = cls2;
                int size = i13 == 0 ? notification.getSecond().getValue().size() : i13;
                RemoteInput.Builder builder = new RemoteInput.Builder("android.intent.extra.TEXT");
                builder.setLabel(string);
                RemoteInput remoteInputBuild = builder.build();
                y.h(remoteInputBuild, "run(...)");
                String.valueOf(notificationId);
                String.valueOf(((INotification) g0.v0(notification.getSecond().getValue())).notificationId());
                ((INotification) g0.v0(notification.getSecond().getValue())).title();
                ((INotification) g0.v0(notification.getSecond().getValue())).getBody();
                Intent intent2 = new Intent(getContext(), (Class<?>) DirectReplyIntent.class);
                intent2.putExtra(ChatParams.FROM_DIRECT_REPLY, true);
                intent2.putExtra("uid", tag);
                XMPPUtils xMPPUtils = XMPPUtils.INSTANCE;
                intent2.putExtra("type", xMPPUtils.isMUC(tag) ? 1 : 0);
                intent2.putExtra("NOTIFICATION", notificationId);
                intent2.setAction("android.intent.action.SEND");
                intent2.setType(MediaUtil.TEXT);
                Context context2 = getContext();
                d.a aVar = d.f40576c;
                int iF = aVar.f();
                int i14 = Build.VERSION.SDK_INT;
                int i15 = size;
                PendingIntent broadcast = PendingIntent.getBroadcast(context2, iF, intent2, i14 >= 31 ? 167772160 : 134217728);
                y.h(broadcast, "getBroadcast(...)");
                Intent intent3 = new Intent(getContext(), (Class<?>) DirectReplyIntent.class);
                intent3.putExtra("uid", tag);
                if (xMPPUtils.isMUC(tag)) {
                    i10 = 1;
                } else if (xMPPUtils.isChannel(tag)) {
                    i10 = 2;
                } else {
                    i10 = xMPPUtils.isCard(tag) ? 3 : 0;
                }
                intent3.putExtra("type", i10);
                intent3.putExtra("NOTIFICATION", notificationId);
                intent3.setAction("NOTIFICATION");
                PendingIntent broadcast2 = PendingIntent.getBroadcast(getContext(), aVar.f(), intent3, i14 >= 31 ? 167772160 : 134217728);
                y.h(broadcast2, "getBroadcast(...)");
                NotificationCompat.Action actionBuild = new NotificationCompat.Action.Builder(R.drawable.reply, string, broadcast).addRemoteInput(remoteInputBuild).setAllowGeneratedReplies(true).setSemanticAction(1).build();
                y.h(actionBuild, "build(...)");
                NotificationCompat.Action actionBuild2 = new NotificationCompat.Action.Builder(R.drawable.message_got_read, str2, broadcast2).setSemanticAction(2).setShowsUserInterface(false).build();
                y.h(actionBuild2, "build(...)");
                Intent intent4 = new Intent("android.intent.action.VIEW", Uri.parse("https://chat.todus.cu/direct/" + tag), getContext(), cls3);
                TaskStackBuilder taskStackBuilderCreate = TaskStackBuilder.create(getContext());
                taskStackBuilderCreate.addNextIntentWithParentStack(intent4);
                PendingIntent pendingIntent = taskStackBuilderCreate.getPendingIntent(0, i14 >= 31 ? 1107296256 : 1073741824);
                y.f(pendingIntent);
                NotificationCompat.Builder color = new NotificationCompat.Builder(getContext(), notification.getSecond().getKey().getTag()).setSmallIcon(R.drawable.icon).setShortcutId(tag).setContentTitle(getContext().getResources().getQuantityString(R.plurals.numberOfNewMessages, i15, Integer.valueOf(i15)) + " de " + ((INotification) g0.v0(notification.getSecond().getValue())).title() + "***").setContentText(((INotification) g0.H0(notification.getSecond().getValue())).getBody()).setCategory("msg").setSound(Uri.parse(notification.getFirst().getSound())).setColor(notification.getFirst().getColor());
                if (messagingStyle2.getMessages().isEmpty()) {
                    color.setStyle(new NotificationCompat.InboxStyle());
                    messagingStyle = messagingStyle2;
                } else {
                    messagingStyle = messagingStyle2;
                    color.setStyle(messagingStyle);
                }
                NotificationCompat.Builder largeIcon = color.setVibrate(new long[]{100, 200, 300, 500}).setGroup(GROUP_KEY_MESSAGE_INCOMING).setContentIntent(pendingIntent).setPriority(5).setLights((int) 4294901760L, 1000, 1000).setColor(ContextCompat.getColor(getContext(), R.color.colorPrimary)).setLargeIcon(((INotification) g0.v0(notification.getSecond().getValue())).picture());
                if (i14 >= 24) {
                    List<NotificationCompat.MessagingStyle.Message> messages = messagingStyle.getMessages();
                    y.h(messages, "getMessages(...)");
                    if (!messages.isEmpty()) {
                        if ((iNotification4 instanceof MessageNotification) && ((MessageNotification) iNotification4).getCantReply()) {
                            largeIcon.addAction(actionBuild);
                        }
                        largeIcon.addAction(actionBuild2);
                    }
                }
                Notification notificationBuild2 = largeIcon.setShowWhen(true).setNumber(i15).setBadgeIconType(1).build();
                y.h(notificationBuild2, "build(...)");
                try {
                    this.notificationManager.notify(notificationId, notificationBuild2);
                    return;
                } catch (Exception e15) {
                    e15.printStackTrace();
                    return;
                }
            } catch (ConcurrentModificationException e16) {
                e = e16;
            }
            e = e;
            e.printStackTrace();
        } catch (ConcurrentModificationException e17) {
            e = e17;
        }
    }

    public final void notifyShowDirectDownloadProgress(String attId, String fileName, long bytesUsed, long totalBytes, boolean isCompleted) {
        y.i(attId, "attId");
        y.i(fileName, "fileName");
        try {
            int notificationId = getNotificationId(ConfigProcessor.INSTANCE.buildHeritageDownload(attId));
            Intent intent = new Intent(getContext(), (Class<?>) CancelTransferReceiver.class);
            intent.setAction("CANCEL_TRANSFER");
            intent.putExtra("ATT_ID", attId);
            boolean z10 = false;
            intent.putExtra("IS_UPLOAD", false);
            PendingIntent broadcast = PendingIntent.getBroadcast(getContext(), notificationId, intent, INSTANCE.retrieveFlags());
            int i10 = totalBytes > 0 ? (int) ((((long) 100) * bytesUsed) / totalBytes) : 0;
            if (totalBytes <= 0 && !isCompleted) {
                z10 = true;
            }
            NotificationCompat.Builder contentTitle = new NotificationCompat.Builder(getContext(), ConfigProcessor.NOTIFICATION_CHANNEL_DOWNLOAD).setSmallIcon(R.drawable.icon).setContentTitle("Descargando " + fileName);
            if (!isCompleted) {
                fileName = NumberInlineFunctionsKt.convertToByteSize(bytesUsed) + " / " + NumberInlineFunctionsKt.convertToByteSize(totalBytes);
            }
            NotificationCompat.Builder priority = contentTitle.setContentText(fileName).setOngoing(!isCompleted).setOnlyAlertOnce(true).setProgress(100, i10, z10).setColorized(true).setPriority(-1);
            y.h(priority, "setPriority(...)");
            if (isCompleted) {
                this.notificationManager.cancel(notificationId);
                return;
            }
            priority.addAction(R.drawable.baseline_cancel_24, getContext().getString(R.string.cancel), broadcast);
            if (Build.VERSION.SDK_INT < 33) {
                this.notificationManager.notify(notificationId, priority.build());
            } else if (ContextCompat.checkSelfPermission(getContext(), "android.permission.POST_NOTIFICATIONS") == 0) {
                this.notificationManager.notify(notificationId, priority.build());
            }
        } catch (Exception e10) {
            Log.e("NOTIF_DOWNLOAD", "Error al mostrar progreso: " + e10.getMessage());
        }
    }

    public final void notifyShowDirectUploadProgress(String msgId, String attId, String fileName, long bytesUsed, long totalBytes, boolean isCompleted) {
        String str;
        y.i(msgId, "msgId");
        y.i(attId, "attId");
        y.i(fileName, "fileName");
        try {
            int notificationId = getNotificationId(ConfigProcessor.INSTANCE.buildHeritageUpload(attId));
            Intent intent = new Intent(getContext(), (Class<?>) CancelTransferReceiver.class);
            intent.setAction("CANCEL_TRANSFER");
            intent.putExtra("ATT_ID", attId);
            intent.putExtra("MSG_ID", msgId);
            intent.putExtra("IS_UPLOAD", true);
            PendingIntent broadcast = PendingIntent.getBroadcast(getContext(), notificationId, intent, INSTANCE.retrieveFlags());
            boolean z10 = false;
            int i10 = totalBytes > 0 ? (int) ((((long) 100) * bytesUsed) / totalBytes) : 0;
            if (totalBytes <= 0 && !isCompleted) {
                z10 = true;
            }
            NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(getContext(), ConfigProcessor.NOTIFICATION_CHANNEL_UPLOAD).setSmallIcon(R.drawable.icon);
            if (isCompleted) {
                str = "Subida completada";
            } else {
                str = "Subiendo " + fileName;
            }
            NotificationCompat.Builder contentTitle = smallIcon.setContentTitle(str);
            if (!isCompleted) {
                fileName = NumberInlineFunctionsKt.convertToByteSize(bytesUsed) + " / " + NumberInlineFunctionsKt.convertToByteSize(totalBytes);
            }
            NotificationCompat.Builder priority = contentTitle.setContentText(fileName).setOngoing(!isCompleted).setOnlyAlertOnce(true).setProgress(100, i10, z10).setColorized(true).setPriority(-1);
            y.h(priority, "setPriority(...)");
            if (isCompleted) {
                this.notificationManager.cancel(notificationId);
                return;
            }
            priority.addAction(R.drawable.baseline_cancel_24, getContext().getString(R.string.cancel), broadcast);
            if (Build.VERSION.SDK_INT < 33) {
                this.notificationManager.notify(notificationId, priority.build());
            } else if (ContextCompat.checkSelfPermission(getContext(), "android.permission.POST_NOTIFICATIONS") == 0) {
                this.notificationManager.notify(notificationId, priority.build());
            }
        } catch (Exception e10) {
            Log.e("NOTIF_UPLOAD", "Error al mostrar progreso: " + e10.getMessage());
        }
    }
}
