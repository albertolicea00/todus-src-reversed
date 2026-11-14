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
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0017\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r¨\u0006\u0018"}, d2 = {"Lcu/todus/android/notification/notifications/UploadNotification;", "Lcu/todus/android/notification/notifications/INotification;", Config.TABLE_NAME, "Lcu/todus/android/data/db/entity/configs/Heritage;", "workId", "", "title", "body", "<init>", "(Lcu/todus/android/data/db/entity/configs/Heritage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getWorkId", "()Ljava/lang/String;", "setWorkId", "(Ljava/lang/String;)V", "getTitle", "setTitle", "getBody", "setBody", "notificationId", "", Room.CONFIG_PICTURE, "Landroid/graphics/Bitmap;", "timestamp", "", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class UploadNotification extends INotification {
    public static final int $stable = 8;
    private String body;
    private Heritage heritage;
    private String title;
    private String workId;

    public UploadNotification(Heritage heritage, String workId, String title, String body) {
        y.i(heritage, "heritage");
        y.i(workId, "workId");
        y.i(title, "title");
        y.i(body, "body");
        this.heritage = heritage;
        this.workId = workId;
        this.title = title;
        this.body = body;
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

    public final String getWorkId() {
        return this.workId;
    }

    @Override // cu.todus.android.notification.notifications.INotification
    /* JADX INFO: renamed from: heritage, reason: from getter */
    public Heritage getHeritage() {
        return this.heritage;
    }

    @Override // cu.todus.android.notification.notifications.INotification
    public int notificationId() {
        return getHeritage().hashCode();
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

    public final void setWorkId(String str) {
        y.i(str, "<set-?>");
        this.workId = str;
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
