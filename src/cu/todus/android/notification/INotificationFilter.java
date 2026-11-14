package cu.todus.android.notification;

import cu.todus.android.data.db.entity.configs.Config;
import cu.todus.android.data.db.entity.configs.Heritage;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcu/todus/android/notification/INotificationFilter;", "", "apply", "", Config.TABLE_NAME, "Lcu/todus/android/data/db/entity/configs/Heritage;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface INotificationFilter {
    boolean apply(Heritage heritage);

    Heritage heritage();
}
