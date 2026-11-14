package cu.todus.android.rest.report;

import ab.e;
import cu.todus.android.constants.Service;
import cu.todus.android.data.rest.request.ReportMessageRequest;
import kotlin.Metadata;
import mi.a0;
import oi.a;
import oi.o;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcu/todus/android/rest/report/ReportService;", "", "Lcu/todus/android/data/rest/request/ReportMessageRequest;", "request", "Lmi/a0;", "reportMessage", "(Lcu/todus/android/data/rest/request/ReportMessageRequest;Lab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ReportService {
    @o(Service.Endpoint.REPORT)
    Object reportMessage(@a ReportMessageRequest reportMessageRequest, e<? super a0<Object>> eVar);
}
