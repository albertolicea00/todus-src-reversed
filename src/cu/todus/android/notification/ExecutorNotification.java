package cu.todus.android.notification;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import cu.todus.android.constants.CloudType;
import cu.todus.android.data.db.entity.configs.Config;
import cu.todus.android.data.db.entity.configs.Heritage;
import cu.todus.android.data.db.entity.configs.Values;
import cu.todus.android.notification.notifications.INotification;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b'\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J5\u0010\u000e\u001a\u00020\r2$\u0010\f\u001a \u0012\u0004\u0012\u00020\u0007\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b0\u0006H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\tH&¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcu/todus/android/notification/ExecutorNotification;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lkotlin/Pair;", "Lcu/todus/android/data/db/entity/configs/Values;", "", "Lcu/todus/android/data/db/entity/configs/Heritage;", "", "Lcu/todus/android/notification/notifications/INotification;", CloudType.WORKER_NOTIFICATION, "Lua/k0;", "notify", "(Lkotlin/Pair;)V", Config.TABLE_NAME, "cancel", "(Lcu/todus/android/data/db/entity/configs/Heritage;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class ExecutorNotification {
    public static final int $stable = 8;
    private final Context context;

    public ExecutorNotification(Context context) {
        y.i(context, "context");
        this.context = context;
    }

    public abstract void cancel(Heritage heritage);

    public final Context getContext() {
        return this.context;
    }

    public abstract void notify(Pair<Values, ? extends Map.Entry<Heritage, ? extends Set<? extends INotification>>> notification);
}
