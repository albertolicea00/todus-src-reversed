package cu.todus.android.notification.notifications;

import android.graphics.Bitmap;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.data.db.entity.configs.Config;
import cu.todus.android.data.db.entity.configs.Heritage;
import cu.todus.android.data.db.entity.toDus.Room;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\f¨\u0006\u0015"}, d2 = {"Lcu/todus/android/notification/notifications/GeneralNotification;", "Lcu/todus/android/notification/notifications/INotification;", Config.TABLE_NAME, "Lcu/todus/android/data/db/entity/configs/Heritage;", "body", "", "title", "<init>", "(Lcu/todus/android/data/db/entity/configs/Heritage;Ljava/lang/String;Ljava/lang/String;)V", "getBody", "()Ljava/lang/String;", "setBody", "(Ljava/lang/String;)V", "getTitle", "setTitle", "notificationId", "", Room.CONFIG_PICTURE, "Landroid/graphics/Bitmap;", "timestamp", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GeneralNotification extends INotification {
    public static final int $stable = 8;
    private String body;
    private Heritage heritage;
    private String title;

    public GeneralNotification(Heritage heritage, String body, String title) {
        y.i(heritage, "heritage");
        y.i(body, "body");
        y.i(title, "title");
        this.heritage = heritage;
        this.body = body;
        this.title = title;
    }

    @Override // cu.todus.android.notification.notifications.INotification
    /* JADX INFO: renamed from: body, reason: from getter */
    public String getBody() {
        return this.body;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getTitle() {
        return this.title;
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
        return null;
    }

    public final void setBody(String str) {
        y.i(str, "<set-?>");
        this.body = str;
    }

    public final void setTitle(String str) {
        y.i(str, "<set-?>");
        this.title = str;
    }

    @Override // cu.todus.android.notification.notifications.INotification
    public long timestamp() {
        return new Date().getTime();
    }

    @Override // cu.todus.android.notification.notifications.INotification
    public String title() {
        return this.title;
    }
}
