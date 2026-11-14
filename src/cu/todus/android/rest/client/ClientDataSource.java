package cu.todus.android.rest.client;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import cu.todus.android.rest.BaseDataSource;
import kotlin.Metadata;
import kotlin.jvm.internal.y;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcu/todus/android/rest/client/ClientDataSource;", "", NotificationCompat.CATEGORY_SERVICE, "Lcu/todus/android/rest/client/ClientService;", "baseDataSource", "Lcu/todus/android/rest/BaseDataSource;", "<init>", "(Lcu/todus/android/rest/client/ClientService;Lcu/todus/android/rest/BaseDataSource;)V", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ClientDataSource {
    public static final int $stable = 8;
    private final BaseDataSource baseDataSource;
    private final ClientService service;

    public ClientDataSource(ClientService service, BaseDataSource baseDataSource) {
        y.i(service, "service");
        y.i(baseDataSource, "baseDataSource");
        this.service = service;
        this.baseDataSource = baseDataSource;
    }
}
