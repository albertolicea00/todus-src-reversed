package cu.todus.android.notification.notifications;

import android.graphics.Bitmap;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.configs.Config;
import cu.todus.android.data.db.entity.configs.Heritage;
import cu.todus.android.data.db.entity.toDus.Room;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\n\u00100\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0014\u00101\u001a\u00020\u00102\b\u00102\u001a\u0004\u0018\u000103H\u0096\u0082\u0004J\n\u00104\u001a\u00020.H\u0096\u0080\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010+R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010+R\u0011\u0010\u0012\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+¨\u00065"}, d2 = {"Lcu/todus/android/notification/notifications/MessageNotification;", "Lcu/todus/android/notification/notifications/INotification;", Config.TABLE_NAME, "Lcu/todus/android/data/db/entity/configs/Heritage;", "roomId", "", "roomName", "senderName", "roomPicture", "Landroid/graphics/Bitmap;", "senderPicture", Room.COLUMN_LAST_MSG, "body", "timestamp", "", "isMention", "", "isReaction", "cantReply", "<init>", "(Lcu/todus/android/data/db/entity/configs/Heritage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;JZZZ)V", "getRoomId", "()Ljava/lang/String;", "setRoomId", "(Ljava/lang/String;)V", "getRoomName", "setRoomName", "getSenderName", "setSenderName", "getRoomPicture", "()Landroid/graphics/Bitmap;", "setRoomPicture", "(Landroid/graphics/Bitmap;)V", "getSenderPicture", "setSenderPicture", "getMsgId", "setMsgId", "getBody", "setBody", "getTimestamp", "()J", "setTimestamp", "(J)V", "()Z", "getCantReply", "notificationId", "", "title", Room.CONFIG_PICTURE, "equals", "other", "", "hashCode", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class MessageNotification extends INotification {
    public static final int $stable = 8;
    private String body;
    private final boolean cantReply;
    private Heritage heritage;
    private final boolean isMention;
    private final boolean isReaction;
    private String msgId;
    private String roomId;
    private String roomName;
    private Bitmap roomPicture;
    private String senderName;
    private Bitmap senderPicture;
    private long timestamp;

    public MessageNotification(Heritage heritage, String roomId, String roomName, String str, Bitmap bitmap, Bitmap bitmap2, String msgId, String body, long j10, boolean z10, boolean z11, boolean z12) {
        y.i(heritage, "heritage");
        y.i(roomId, "roomId");
        y.i(roomName, "roomName");
        y.i(msgId, "msgId");
        y.i(body, "body");
        this.heritage = heritage;
        this.roomId = roomId;
        this.roomName = roomName;
        this.senderName = str;
        this.roomPicture = bitmap;
        this.senderPicture = bitmap2;
        this.msgId = msgId;
        this.body = body;
        this.timestamp = j10;
        this.isMention = z10;
        this.isReaction = z11;
        this.cantReply = z12;
    }

    @Override // cu.todus.android.notification.notifications.INotification
    /* JADX INFO: renamed from: body, reason: from getter */
    public String getBody() {
        return this.body;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageNotification)) {
            return false;
        }
        MessageNotification messageNotification = (MessageNotification) other;
        return y.d(this.roomId, messageNotification.roomId) && y.d(this.msgId, messageNotification.msgId) && !this.isReaction;
    }

    public final String getBody() {
        return this.body;
    }

    public final boolean getCantReply() {
        return this.cantReply;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getRoomName() {
        return this.roomName;
    }

    public final Bitmap getRoomPicture() {
        return this.roomPicture;
    }

    public final String getSenderName() {
        return this.senderName;
    }

    public final Bitmap getSenderPicture() {
        return this.senderPicture;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (this.roomId.hashCode() * 31) + this.msgId.hashCode();
    }

    @Override // cu.todus.android.notification.notifications.INotification
    /* JADX INFO: renamed from: heritage, reason: from getter */
    public Heritage getHeritage() {
        return this.heritage;
    }

    /* JADX INFO: renamed from: isMention, reason: from getter */
    public final boolean getIsMention() {
        return this.isMention;
    }

    /* JADX INFO: renamed from: isReaction, reason: from getter */
    public final boolean getIsReaction() {
        return this.isReaction;
    }

    @Override // cu.todus.android.notification.notifications.INotification
    public int notificationId() {
        if (y.d(this.roomId, "toDus@im.todus.cu")) {
            return 1;
        }
        int iHashCode = getHeritage().hashCode();
        return iHashCode < 1 ? iHashCode * (-1) : iHashCode;
    }

    @Override // cu.todus.android.notification.notifications.INotification
    public Bitmap picture() {
        return this.roomPicture;
    }

    public final void setBody(String str) {
        y.i(str, "<set-?>");
        this.body = str;
    }

    public final void setMsgId(String str) {
        y.i(str, "<set-?>");
        this.msgId = str;
    }

    public final void setRoomId(String str) {
        y.i(str, "<set-?>");
        this.roomId = str;
    }

    public final void setRoomName(String str) {
        y.i(str, "<set-?>");
        this.roomName = str;
    }

    public final void setRoomPicture(Bitmap bitmap) {
        this.roomPicture = bitmap;
    }

    public final void setSenderName(String str) {
        this.senderName = str;
    }

    public final void setSenderPicture(Bitmap bitmap) {
        this.senderPicture = bitmap;
    }

    public final void setTimestamp(long j10) {
        this.timestamp = j10;
    }

    @Override // cu.todus.android.notification.notifications.INotification
    public long timestamp() {
        return this.timestamp;
    }

    @Override // cu.todus.android.notification.notifications.INotification
    public String title() {
        return this.roomName;
    }

    public /* synthetic */ MessageNotification(Heritage heritage, String str, String str2, String str3, Bitmap bitmap, Bitmap bitmap2, String str4, String str5, long j10, boolean z10, boolean z11, boolean z12, int i10, p pVar) {
        this(heritage, str, str2, str3, (i10 & 16) != 0 ? null : bitmap, (i10 & 32) != 0 ? null : bitmap2, str4, str5, (i10 & 256) != 0 ? new Date().getTime() : j10, (i10 & 512) != 0 ? false : z10, (i10 & 1024) != 0 ? false : z11, (i10 & 2048) != 0 ? true : z12);
    }
}
