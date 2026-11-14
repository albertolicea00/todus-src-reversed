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
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\n\u0010 \u001a\u0004\u0018\u00010\bH\u0016J\b\u0010!\u001a\u00020\"H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006#"}, d2 = {"Lcu/todus/android/notification/notifications/UnreadMessageNotification;", "Lcu/todus/android/notification/notifications/INotification;", Config.TABLE_NAME, "Lcu/todus/android/data/db/entity/configs/Heritage;", "roomId", "", "roomName", "roomPicture", "Landroid/graphics/Bitmap;", "body", "count", "", "<init>", "(Lcu/todus/android/data/db/entity/configs/Heritage;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/lang/String;I)V", "getRoomId", "()Ljava/lang/String;", "setRoomId", "(Ljava/lang/String;)V", "getRoomName", "setRoomName", "getRoomPicture", "()Landroid/graphics/Bitmap;", "setRoomPicture", "(Landroid/graphics/Bitmap;)V", "getBody", "setBody", "getCount", "()I", "setCount", "(I)V", "notificationId", "title", Room.CONFIG_PICTURE, "timestamp", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UnreadMessageNotification extends INotification {
    public static final int $stable = 8;
    private String body;
    private int count;
    private Heritage heritage;
    private String roomId;
    private String roomName;
    private Bitmap roomPicture;

    public UnreadMessageNotification(Heritage heritage, String roomId, String roomName, Bitmap bitmap, String body, int i10) {
        y.i(heritage, "heritage");
        y.i(roomId, "roomId");
        y.i(roomName, "roomName");
        y.i(body, "body");
        this.heritage = heritage;
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomPicture = bitmap;
        this.body = body;
        this.count = i10;
    }

    @Override // cu.todus.android.notification.notifications.INotification
    /* JADX INFO: renamed from: body, reason: from getter */
    public String getBody() {
        return this.body;
    }

    public final String getBody() {
        return this.body;
    }

    public final int getCount() {
        return this.count;
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

    @Override // cu.todus.android.notification.notifications.INotification
    /* JADX INFO: renamed from: heritage, reason: from getter */
    public Heritage getHeritage() {
        return this.heritage;
    }

    @Override // cu.todus.android.notification.notifications.INotification
    public int notificationId() {
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

    public final void setCount(int i10) {
        this.count = i10;
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

    @Override // cu.todus.android.notification.notifications.INotification
    public long timestamp() {
        return new Date().getTime();
    }

    @Override // cu.todus.android.notification.notifications.INotification
    public String title() {
        return this.roomName;
    }

    public /* synthetic */ UnreadMessageNotification(Heritage heritage, String str, String str2, Bitmap bitmap, String str3, int i10, int i11, p pVar) {
        this(heritage, str, str2, (i11 & 8) != 0 ? null : bitmap, str3, (i11 & 32) != 0 ? 0 : i10);
    }
}
