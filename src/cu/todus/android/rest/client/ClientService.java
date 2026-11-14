package cu.todus.android.rest.client;

import ab.e;
import cu.todus.android.constants.Service;
import cu.todus.android.data.rest.request.LinkRequest;
import cu.todus.android.data.rest.response.LastReleaseResponse;
import cu.todus.android.data.rest.response.LinkResponse;
import kotlin.Metadata;
import mi.a0;
import oi.a;
import oi.f;
import oi.k;
import oi.o;

/* JADX INFO: compiled from: r8-map-id-6f96ac19fe2c64a3894d8540d8e2f71367631717ee9450b2dd81fd70d133ae29 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\u0006\u0010\u0005J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H§@¢\u0006\u0004\b\u0007\u0010\u0005J \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\b\b\u0001\u0010\t\u001a\u00020\bH§@¢\u0006\u0004\b\u000b\u0010\f¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcu/todus/android/rest/client/ClientService;", "", "Lmi/a0;", "Lcu/todus/android/data/rest/response/LastReleaseResponse;", "lastReleaseFromToDus", "(Lab/e;)Ljava/lang/Object;", "lastBetaFromToDus", "lastRelease", "Lcu/todus/android/data/rest/request/LinkRequest;", "body", "Lcu/todus/android/data/rest/response/LinkResponse;", "downloadLink", "(Lcu/todus/android/data/rest/request/LinkRequest;Lab/e;)Ljava/lang/Object;", "app_productionPFast"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ClientService {
    @k({"Content-Type: application/json"})
    @o("https://api.apklis.cu/v2/release/get_url/")
    Object downloadLink(@a LinkRequest linkRequest, e<? super a0<LinkResponse>> eVar);

    @f(Service.Endpoint.LATEST_BETA)
    Object lastBetaFromToDus(e<? super a0<LastReleaseResponse>> eVar);

    @f("https://api.apklis.cu/v1/application/338/")
    Object lastRelease(e<? super a0<LastReleaseResponse>> eVar);

    @f(Service.Endpoint.LATEST)
    Object lastReleaseFromToDus(e<? super a0<LastReleaseResponse>> eVar);
}
