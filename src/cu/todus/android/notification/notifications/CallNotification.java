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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0017\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcu/todus/android/notification/notifications/CallNotification;", "Lcu/todus/android/notification/notifications/INotification;", Config.TABLE_NAME, "Lcu/todus/android/data/db/entity/configs/Heritage;", "id", "", "name", "image", "isVideoCall", "", "<init>", "(Lcu/todus/android/data/db/entity/configs/Heritage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "setName", "getImage", "setImage", "()Z", "setVideoCall", "(Z)V", "notificationId", "", "title", "body", Room.CONFIG_PICTURE, "Landroid/graphics/Bitmap;", "timestamp", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class CallNotification extends INotification {
    public static final int $stable = 8;
    private Heritage heritage;
    private String id;
    private String image;
    private boolean isVideoCall;
    private String name;

    public CallNotification(Heritage heritage, String id2, String name, String image, boolean z10) {
        y.i(heritage, "heritage");
        y.i(id2, "id");
        y.i(name, "name");
        y.i(image, "image");
        this.heritage = heritage;
        this.id = id2;
        this.name = name;
        this.image = image;
        this.isVideoCall = z10;
    }

    @Override // cu.todus.android.notification.notifications.INotification
    /* JADX INFO: renamed from: body */
    public String getBody() {
        return "";
    }

    public final String getId() {
        return this.id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getName() {
        return this.name;
    }

    @Override // cu.todus.android.notification.notifications.INotification
    /* JADX INFO: renamed from: heritage, reason: from getter */
    public Heritage getHeritage() {
        return this.heritage;
    }

    /* JADX INFO: renamed from: isVideoCall, reason: from getter */
    public final boolean getIsVideoCall() {
        return this.isVideoCall;
    }

    @Override // cu.todus.android.notification.notifications.INotification
    public int notificationId() {
        int iHashCode = getHeritage().hashCode();
        return iHashCode < 1 ? iHashCode * (-1) : iHashCode;
    }

    @Override // cu.todus.android.notification.notifications.INotification
    public Bitmap picture() {
        return null;
    }

    public final void setId(String str) {
        y.i(str, "<set-?>");
        this.id = str;
    }

    public final void setImage(String str) {
        y.i(str, "<set-?>");
        this.image = str;
    }

    public final void setName(String str) {
        y.i(str, "<set-?>");
        this.name = str;
    }

    public final void setVideoCall(boolean z10) {
        this.isVideoCall = z10;
    }

    @Override // cu.todus.android.notification.notifications.INotification
    public long timestamp() {
        return new Date().getTime();
    }

    @Override // cu.todus.android.notification.notifications.INotification
    public String title() {
        return this.name;
    }

    public /* synthetic */ CallNotification(Heritage heritage, String str, String str2, String str3, boolean z10, int i10, p pVar) {
        this(heritage, str, str2, str3, (i10 & 16) != 0 ? false : z10);
    }
}
