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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006%"}, d2 = {"Lcu/todus/android/notification/notifications/DownloadNotification;", "Lcu/todus/android/notification/notifications/INotification;", Config.TABLE_NAME, "Lcu/todus/android/data/db/entity/configs/Heritage;", "workId", "", "title", "body", "bytesUsed", "", "bytesTotal", "isCompleted", "", "<init>", "(Lcu/todus/android/data/db/entity/configs/Heritage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJZ)V", "getWorkId", "()Ljava/lang/String;", "setWorkId", "(Ljava/lang/String;)V", "getTitle", "setTitle", "getBody", "setBody", "getBytesUsed", "()J", "setBytesUsed", "(J)V", "getBytesTotal", "setBytesTotal", "()Z", "setCompleted", "(Z)V", "notificationId", "", Room.CONFIG_PICTURE, "Landroid/graphics/Bitmap;", "timestamp", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class DownloadNotification extends INotification {
    public static final int $stable = 8;
    private String body;
    private long bytesTotal;
    private long bytesUsed;
    private Heritage heritage;
    private boolean isCompleted;
    private String title;
    private String workId;

    public DownloadNotification(Heritage heritage, String workId, String title, String body, long j10, long j11, boolean z10) {
        y.i(heritage, "heritage");
        y.i(workId, "workId");
        y.i(title, "title");
        y.i(body, "body");
        this.heritage = heritage;
        this.workId = workId;
        this.title = title;
        this.body = body;
        this.bytesUsed = j10;
        this.bytesTotal = j11;
        this.isCompleted = z10;
    }

    @Override // cu.todus.android.notification.notifications.INotification
    /* JADX INFO: renamed from: body, reason: from getter */
    public String getBody() {
        return this.body;
    }

    public final String getBody() {
        return this.body;
    }

    public final long getBytesTotal() {
        return this.bytesTotal;
    }

    public final long getBytesUsed() {
        return this.bytesUsed;
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

    /* JADX INFO: renamed from: isCompleted, reason: from getter */
    public final boolean getIsCompleted() {
        return this.isCompleted;
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

    public final void setBytesTotal(long j10) {
        this.bytesTotal = j10;
    }

    public final void setBytesUsed(long j10) {
        this.bytesUsed = j10;
    }

    public final void setCompleted(boolean z10) {
        this.isCompleted = z10;
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

    public /* synthetic */ DownloadNotification(Heritage heritage, String str, String str2, String str3, long j10, long j11, boolean z10, int i10, p pVar) {
        this(heritage, str, str2, str3, (i10 & 16) != 0 ? 0L : j10, (i10 & 32) != 0 ? 0L : j11, (i10 & 64) != 0 ? false : z10);
    }
}
